package com.comerce.comerce.repository;

import com.comerce.comerce.repository.models.PriceDTO;

import org.springframework.data.repository.CrudRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface PriceRepository extends CrudRepository<PriceDTO,Long> {
    Optional<List<PriceDTO>> findByproductIdAndCorporateIdAndEndDateIsAfterAndStartDateIsBefore
            (Integer productId, Integer corporateid , LocalDateTime enddate, LocalDateTime startdate );
}
