package com.comerce.comerce.controllers.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class ProductAllRSPDTO {


    List<ProductResponseDTO> data;

    public ProductAllRSPDTO(List<ProductResponseDTO> productResponseDTOList) {
        this.data = productResponseDTOList;

    }

}