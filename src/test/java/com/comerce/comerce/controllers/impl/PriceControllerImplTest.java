package com.comerce.comerce.controllers.impl;

import com.comerce.comerce.exceptions.WrongCorporateIdException;
import com.comerce.comerce.repository.ProductRepository;
import com.comerce.comerce.repository.models.PriceDTO;
import com.comerce.comerce.services.ProductService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PricesControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductRepository productRepository;

    @Autowired
    @Qualifier("ProductServiceImpl")
    ProductService productService;

    private static LocalDateTime date;

    @BeforeAll
    public static void init() {
        date = LocalDateTime.now();
    }

    /*

    Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:


            -          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)

            -          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)

            -          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)

            -          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)

            -          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)


 */

    @Test
    @DisplayName(value = "Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void given_OkRequestAt10hWhen_tryToGetThen_getTheData() throws Exception {

        Mockito.when(productRepository.findByproductIdAndCorporateIdAndEndDateIsAfterAndStartDateIsBefore(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(createOptionalListPrice());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/v1/corporates/{corporateId}/products/{productId}/seasons", "1", "35455")
                        .param("date", "2020-10-14T10:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].productId", Matchers.is("35455")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].groupID", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].cost", Matchers.is("36")));


    }

    @Test
    @DisplayName(value = "Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void given_OkRequestAt16When_tryToGetThen_getTheData() throws Exception {

        Mockito.when(productRepository.findByproductIdAndCorporateIdAndEndDateIsAfterAndStartDateIsBefore(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(createOptionalListPrice());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/v1/corporates/{corporateId}/products/{productId}/seasons", "1", "35455")
                        .param("date", "2020-10-14T16:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].productId", Matchers.is("35455")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].groupID", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].cost", Matchers.is("36")));


    }

    @Test
    @DisplayName(value = "Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void given_OkRequestAt21When_tryToGetThen_getTheData() throws Exception {

        Mockito.when(productRepository.findByproductIdAndCorporateIdAndEndDateIsAfterAndStartDateIsBefore(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(createOptionalListPrice());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/v1/corporates/{corporateId}/products/{productId}/seasons", "1", "35455")
                        .param("date", "2020-10-14T21:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].productId", Matchers.is("35455")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].groupID", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].cost", Matchers.is("36")));


    }

    @Test
    @DisplayName(value = "Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
    void given_OkRequest10When_tryToGetThen_getTheData() throws Exception {

        Mockito.when(productRepository.findByproductIdAndCorporateIdAndEndDateIsAfterAndStartDateIsBefore(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(createOptionalListPrice());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/v1/corporates/{corporateId}/products/{productId}/seasons", "1", "35455")
                        .param("date", "2020-10-15T10:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].productId", Matchers.is("35455")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].groupID", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].cost", Matchers.is("36")));


    }

    @Test
    @DisplayName(value = "Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
    void given_OkRequestWhen_tryToGetThen_getTheData() throws Exception {

        Mockito.when(productRepository.findByproductIdAndCorporateIdAndEndDateIsAfterAndStartDateIsBefore(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(createOptionalListPrice());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/v1/corporates/{corporateId}/products/{productId}/seasons", "1", "35455")
                        .param("date", "2020-10-16T21:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].productId", Matchers.is("35455")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].groupID", Matchers.is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.[0].cost", Matchers.is("36")));


    }
    //TODO: hacer los test 1 a 5 con datos de la DB en vez de Mock

    @Test
    @DisplayName(value = "Test 6: peticion incorrecta para el corporateID (brand)  2 (ZARA)")
    void given_KORequestNoValidCorporateIDWhen_tryToGetThen_getInvalidCorporateIDException() throws Exception {

        Mockito.when(productRepository.findByproductIdAndCorporateIdAndEndDateIsAfterAndStartDateIsBefore(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(createOptionalListPrice());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/v1/corporates/{corporateId}/products/{productId}/seasons", "2", "35455")
                        .param("date", "2020-10-16T21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof WrongCorporateIdException));


    }

    //TODO: hacer test para fecha errónea o nula
    //TODO: hacer test para corporateID y productID errónea o nula
    //TODO: Expected para fecha devuelta

    private Optional<java.util.List<PriceDTO>> createOptionalListPrice() {
        return Optional.of(createPriceDTOList());

    }

    private java.util.List<PriceDTO> createPriceDTOList() {

        List<PriceDTO> priceDTOList = new ArrayList<>();
        priceDTOList.add(createPriceDTO());
        return priceDTOList;
    }

    private PriceDTO createPriceDTO() {
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setProductId(35455);
        priceDTO.setCorporateId(1);
        priceDTO.setCost(36L);
        priceDTO.setCurrencyIso("EUR");
        priceDTO.setEndDate(date);
        priceDTO.setStartDate(date);
        priceDTO.setPriceRatesId(1L);
        return priceDTO;
    }

}



