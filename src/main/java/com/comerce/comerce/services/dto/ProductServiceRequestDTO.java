package com.comerce.comerce.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ProductServiceRequestDTO {
    private Integer productId;
    private Integer corporateId;
    private LocalDateTime applicationDate;

}
