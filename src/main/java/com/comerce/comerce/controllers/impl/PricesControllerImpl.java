package com.comerce.comerce.controllers.impl;

import com.comerce.comerce.controllers.PriceController;
import com.comerce.comerce.controllers.dto.ProductAllRSPDTO;
import com.comerce.comerce.mapper.Mapper;
import com.comerce.comerce.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/v1")
@Slf4j
public class PricesControllerImpl implements PriceController {

    @Autowired()
    @Qualifier("ProductServiceImpl")
    ProductService productService;


    //fecha de aplicación, identificador de producto, identificador de cadena.
    @Override
    @GetMapping(value = "corporates/{corporateId}/products/{productId}/seasons" )
    public ResponseEntity<ProductAllRSPDTO> getProductByIdAndFilteringByCorporateIdAndDate(@PathVariable("corporateId") String corporateId,
                                                                                           @PathVariable("productId") String productId,
                                                                                           @RequestParam(name = "date", required = false) String applicationDate) {
        log.info("getProductByIdAndFilteringByCorporateIdAndDate Controller");
        //TODO hacer el mapeo con un mapping Generator
        ProductAllRSPDTO productAllRSPDTO = new ProductAllRSPDTO(Mapper.fromProductServiceResponseListDTOtoProductResponseList(
                productService.getProductByIdAndFilteringByCorporateIdAndDate(Mapper.toProductServiceRequestDTO(productId, corporateId, applicationDate))));
        HttpStatus httpStatus;

        if (ObjectUtils.isEmpty(productAllRSPDTO.getData())) {
            httpStatus = HttpStatus.NO_CONTENT;
        } else {
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity(productAllRSPDTO, httpStatus);
    }



}
