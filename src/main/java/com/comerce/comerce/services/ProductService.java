package com.comerce.comerce.services;

import com.comerce.comerce.services.dto.ProductServiceRequestDTO;
import com.comerce.comerce.services.dto.ProductServiceResponseDTO;

import java.util.List;

public interface ProductService {
    // solo para usar static en interfaces
    static String CTE_CONSTAND = "Constand";

    List<ProductServiceResponseDTO> getProductByIdAndFilteringByCorporateIdAndDate(String corporateId, String productId, String applicationDate);
}
