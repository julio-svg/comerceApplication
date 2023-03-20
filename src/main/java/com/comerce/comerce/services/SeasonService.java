package com.comerce.comerce.services;

import com.comerce.comerce.services.dto.SeasonServiceResponseDTO;

import java.util.List;

public interface SeasonService {
    // solo para usar static en interfaces
    static String CTE_CONSTAND = "Constand";

    List<SeasonServiceResponseDTO> getProductByIdAndFilteringByCorporateIdAndDate(String corporateId, String productId, String applicationDate);
}
