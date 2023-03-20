package com.comerce.comerce.mapper;

import com.comerce.comerce.controllers.dto.SeasonResponseDTO;
import com.comerce.comerce.repository.models.PriceDTO;
import com.comerce.comerce.services.dto.SeasonServiceRequestDTO;
import com.comerce.comerce.services.dto.SeasonServiceResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class Mapper {

    private Mapper() {

    }

    // Se usa constructores para evitar setters
    public static SeasonServiceRequestDTO toProductServiceRequestDTO(String productId, String corporateId, String applicationDate) {
        LocalDateTime dateTime = LocalDateTime.parse(applicationDate, ISO_LOCAL_DATE_TIME);
        return new SeasonServiceRequestDTO(Integer.valueOf(productId), Integer.valueOf(corporateId), dateTime);
    }


    // se usan Setter para evitar un constructor de mas de 3 parametros cleanCode
    public static List<SeasonResponseDTO> fromProductServiceResponseListDTOtoProductResponseList(List<SeasonServiceResponseDTO> seasonServiceResponseDTOList) {

        return seasonServiceResponseDTOList.stream().map(seasonServiceResponseDTO -> {
            SeasonResponseDTO productService = new SeasonResponseDTO();
            productService.setProductId(seasonServiceResponseDTO.getProductId().toString());
            productService.setCost(seasonServiceResponseDTO.getCost());
            productService.setEndDateTime(seasonServiceResponseDTO.getEndDateTime());
            productService.setStartDateTime(seasonServiceResponseDTO.getStartDateTime());
            productService.setGroupID(seasonServiceResponseDTO.getCorporateId().toString());
            return productService;
        }).collect(Collectors.toList());

    }


    public static List<SeasonServiceResponseDTO> fromPricesDTOListToProductServiceResponseDTOList(Optional<List<PriceDTO>> optionalPriceDTOList) {


        if (optionalPriceDTOList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return optionalPriceDTOList.get().stream().map(priceDTO -> {
                SeasonServiceResponseDTO seasonServiceResponseDTO = new SeasonServiceResponseDTO();
                seasonServiceResponseDTO.setProductId(priceDTO.getProductId());
                seasonServiceResponseDTO.setCorporateId(priceDTO.getCorporateId());
                seasonServiceResponseDTO.setEndDateTime(priceDTO.getEndDate());
                seasonServiceResponseDTO.setPriceRatesId(priceDTO.getPriceRatesId());
                seasonServiceResponseDTO.setStartDateTime(priceDTO.getStartDate());
                seasonServiceResponseDTO.setCost(priceDTO.getCost().toString());
                seasonServiceResponseDTO.setPriorityPriceApplication(priceDTO.getPriorityPriceApplication());
                return seasonServiceResponseDTO;
            }).collect(Collectors.toList());
        }

    }

}