package com.comerce.comerce.controllers.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class SeasonAllRSPDTO {


    List<SeasonResponseDTO> data;

    public SeasonAllRSPDTO(List<SeasonResponseDTO> seasonResponseDTOList) {
        this.data = seasonResponseDTOList;

    }

}