package com.comerce.comerce.services.impl;

import com.comerce.comerce.mapper.Mapper;
import com.comerce.comerce.repository.PriceRepository;
import com.comerce.comerce.services.SeasonService;
import com.comerce.comerce.services.dto.SeasonServiceResponseDTO;
import com.comerce.comerce.validator.SeasonValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.UnaryOperator;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

// para poder usar el Qualifier
@Service("ProductServiceImpl")
@Slf4j
public class SeasonServiceImpl implements SeasonService {


   UnaryOperator<List<SeasonServiceResponseDTO>> getOnlyTheRegisterWithBiggestPriority = productServiceResponseDTOList -> productServiceResponseDTOList.stream()
           .max((a , b) -> {
               if(a.getPriorityPriceApplication() >= b.getPriorityPriceApplication()){
                   return 1;
               }
                   return -1;
           }).stream().toList();


    @Autowired
    PriceRepository priceRepository;

    @Autowired
    SeasonValidator seasonValidator;


    @Override
    public List<SeasonServiceResponseDTO> getProductByIdAndFilteringByCorporateIdAndDate(String corporateId, String productId, String applicationDate) {

        log.info("ProductServiceImpl getProductByIdAndFilteringByCorporateIdAndDate");
        seasonValidator.validateinput(corporateId,productId,applicationDate);

        LocalDateTime endDate = LocalDateTime.parse(applicationDate, ISO_LOCAL_DATE_TIME);
        LocalDateTime startDate = LocalDateTime.parse(applicationDate, ISO_LOCAL_DATE_TIME);

        List<SeasonServiceResponseDTO> seasonServiceResponseDTOList =  Mapper.fromPricesDTOListToProductServiceResponseDTOList(
                priceRepository.findByproductIdAndCorporateIdAndEndDateIsAfterAndStartDateIsBefore(Integer.valueOf(productId), Integer.valueOf(corporateId), endDate, startDate));

        return getOnlyTheRegisterWithBiggestPriority.apply(seasonServiceResponseDTOList);

    }
}
