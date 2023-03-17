package com.comerce.comerce.mapper;

import com.comerce.comerce.controllers.dto.ProductResponseDTO;
import com.comerce.comerce.repository.models.PriceDTO;
import com.comerce.comerce.services.dto.ProductServiceRequestDTO;
import com.comerce.comerce.services.dto.ProductServiceResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class Mapper {

    private Mapper() {

    }

    // Se usa constructores para evitar setters
    public static ProductServiceRequestDTO toProductServiceRequestDTO(String productId, String corporateId, String applicationDate) {
        LocalDateTime dateTime = LocalDateTime.parse(applicationDate, ISO_LOCAL_DATE_TIME);

        return new ProductServiceRequestDTO(Integer.valueOf(productId), Integer.valueOf(corporateId), dateTime);
    }


    // se usan Setter para evitar un constructor de mas de 3 parametros cleanCode
    public static List<ProductResponseDTO> fromProductServiceResponseListDTOtoProductResponseList(List<ProductServiceResponseDTO> productServiceResponseDTOList) {

        return productServiceResponseDTOList.stream().map(productServiceResponseDTO -> {
            ProductResponseDTO productService = new ProductResponseDTO();
            productService.setProductId(productServiceResponseDTO.getProductId());
            productService.setCost(productServiceResponseDTO.getCost());
            productService.setEndDateTime(productServiceResponseDTO.getEndDateTime());
            productService.setStartDateTime(productServiceResponseDTO.getStartDateTime());
            productService.setGroupID(productServiceResponseDTO.getCorporateId());
            return productService;
        }).collect(Collectors.toList());

    }


    public static List<ProductServiceResponseDTO> fromPricesDTOListToProductServiceResponseDTOList(Optional<List<PriceDTO>> optionalPriceDTOList) {


        if (optionalPriceDTOList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return optionalPriceDTOList.get().stream().map(priceDTO -> {
                ProductServiceResponseDTO productServiceResponseDTO = new ProductServiceResponseDTO();
                productServiceResponseDTO.setProductId(priceDTO.getProductId().toString());
                productServiceResponseDTO.setCorporateId(priceDTO.getCorporateId().toString());
                productServiceResponseDTO.setEndDateTime(priceDTO.getEndDate());
                productServiceResponseDTO.setPriceRatesId(priceDTO.getPriceRatesId().toString());
                productServiceResponseDTO.setStartDateTime(priceDTO.getStartDate());
                productServiceResponseDTO.setCost(priceDTO.getCost().toString());
                return productServiceResponseDTO;
            }).collect(Collectors.toList());
        }

    }

}