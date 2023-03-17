package com.comerce.comerce.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductServiceResponseDTO {
    private String productId;
    private String corporateId;
    private String priceRatesId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String cost;
}
