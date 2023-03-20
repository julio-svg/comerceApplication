package com.comerce.comerce.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SeasonServiceResponseDTO {
    private Integer productId;
    private Integer corporateId;
    private Long priceRatesId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Integer priorityPriceApplication;
    private String cost;
}
