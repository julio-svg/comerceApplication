package com.comerce.comerce.services.impl;

import com.comerce.comerce.mapper.Mapper;
import com.comerce.comerce.repository.ProductRepository;
import com.comerce.comerce.services.ProductService;
import com.comerce.comerce.services.dto.ProductServiceRequestDTO;
import com.comerce.comerce.services.dto.ProductServiceResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// para poder usar el Qualifier
@Service("ProductServiceImpl")
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<ProductServiceResponseDTO> getProductByIdAndFilteringByCorporateIdAndDate(ProductServiceRequestDTO productServiceRequestDTO) {
        log.info("ProductServiceImpl getProductByIdAndFilteringByCorporateIdAndDate");

        return Mapper.fromPricesDTOListToProductServiceResponseDTOList(productRepository.findBypriceRatesIdAndCorporateIdAndEndDateIsLessThanEqualAndStartDateIsGreaterThanEqual(productServiceRequestDTO.getProductId(), productServiceRequestDTO.getCorporateId(), productServiceRequestDTO.getApplicationDate(), productServiceRequestDTO.getApplicationDate()));

    }
}
