package com.comerce.comerce.repository;

import com.comerce.comerce.repository.models.PriceDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<List<PriceDTO>> findBypriceRatesIdAndCorporateIdAndEndDateIsLessThanEqualAndStartDateIsGreaterThanEqual
            (Integer priceratesid, Integer corporateid , LocalDateTime enddate, LocalDateTime startdate );
}
