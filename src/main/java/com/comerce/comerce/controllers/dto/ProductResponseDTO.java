package com.comerce.comerce.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductResponseDTO implements Serializable {

    private String productId;
    private String groupID;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String cost;


}
