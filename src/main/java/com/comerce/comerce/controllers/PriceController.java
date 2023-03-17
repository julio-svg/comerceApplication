package com.comerce.comerce.controllers;

import com.comerce.comerce.controllers.dto.ProductAllRSPDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface PriceController {
    ResponseEntity<ProductAllRSPDTO> getProductByIdAndFilteringByCorporateIdAndDate(String corporateId, String productId, String applicationDate);

    // para usar default interfaces
    default ResponseEntity<Void> getProuduct(){
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }
}
