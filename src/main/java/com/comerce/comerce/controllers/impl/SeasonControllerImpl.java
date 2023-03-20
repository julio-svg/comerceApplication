package com.comerce.comerce.controllers.impl;

import com.comerce.comerce.controllers.SeasonController;
import com.comerce.comerce.controllers.dto.SeasonAllRSPDTO;
import com.comerce.comerce.mapper.Mapper;
import com.comerce.comerce.services.SeasonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/v1")
@Slf4j
public class SeasonControllerImpl implements SeasonController {

    @Autowired()
    @Qualifier("ProductServiceImpl")
    SeasonService seasonService;


    //fecha de aplicación, identificador de producto, identificador de cadena.
    @Override
    @GetMapping(value = "corporates/{corporateId}/products/{productId}/seasons" )
    public ResponseEntity<SeasonAllRSPDTO> getProductByIdAndFilteringByCorporateIdAndDate(@PathVariable("corporateId") String corporateId,
                                                                                          @PathVariable("productId") String productId,
                                                                                          @RequestParam(name = "date", required = false) String applicationDate) {
        log.info("getProductByIdAndFilteringByCorporateIdAndDate Controller");
        //TODO hacer el mapeo con un mapping Generator
        SeasonAllRSPDTO seasonAllRSPDTO = new SeasonAllRSPDTO(Mapper.fromProductServiceResponseListDTOtoProductResponseList(
                seasonService.getProductByIdAndFilteringByCorporateIdAndDate(corporateId, productId, applicationDate)));
        HttpStatus httpStatus;

        if (ObjectUtils.isEmpty(seasonAllRSPDTO.getData())) {
            httpStatus = HttpStatus.NO_CONTENT;
        } else {
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity(seasonAllRSPDTO, httpStatus);
    }



}
