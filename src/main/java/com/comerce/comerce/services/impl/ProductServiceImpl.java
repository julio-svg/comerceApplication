package com.comerce.comerce.services.impl;

import com.comerce.comerce.mapper.Mapper;
import com.comerce.comerce.repository.ProductRepository;
import com.comerce.comerce.services.ProductService;
import com.comerce.comerce.services.dto.ProductServiceResponseDTO;
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
public class ProductServiceImpl implements ProductService {


   UnaryOperator<List<ProductServiceResponseDTO>> getOnlyTheRegisterWithBiggestPriority = productServiceResponseDTOList -> productServiceResponseDTOList.stream()
           .max((a , b) -> {
               if(a.getPriorityPriceApplication() >= b.getPriorityPriceApplication()){
                   return 1;
               }
                   return -1;
           }).stream().toList();


    @Autowired
    ProductRepository productRepository;

    @Autowired
    SeasonValidator seasonValidator;


    @Override
    public List<ProductServiceResponseDTO> getProductByIdAndFilteringByCorporateIdAndDate(String corporateId, String productId, String applicationDate) {

        log.info("ProductServiceImpl getProductByIdAndFilteringByCorporateIdAndDate");
        seasonValidator.validateinput(corporateId,productId,applicationDate);

        LocalDateTime endDate = LocalDateTime.parse(applicationDate, ISO_LOCAL_DATE_TIME);
        LocalDateTime startDate = LocalDateTime.parse(applicationDate, ISO_LOCAL_DATE_TIME);

        List<ProductServiceResponseDTO> productServiceResponseDTOList =  Mapper.fromPricesDTOListToProductServiceResponseDTOList(
                productRepository.findByproductIdAndCorporateIdAndEndDateIsAfterAndStartDateIsBefore(Integer.valueOf(productId), Integer.valueOf(corporateId), endDate, startDate));

        return getOnlyTheRegisterWithBiggestPriority.apply(productServiceResponseDTOList);

    }
}
