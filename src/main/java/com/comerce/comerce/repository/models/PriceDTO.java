package com.comerce.comerce.repository.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Getter
@Setter
public class PriceDTO implements Serializable {

    @Column(name = "brand_id")
    @NotEmpty(message = "corporateID may not be empty")
    @Size(min = 1, max = 1, message = "corporateId must be between 1 and 1 characters long")
    private Integer corporateId;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceRatesId;

    @Column(name = "product_id")
    @NotEmpty(message = "productId may not be empty")
    @Size(min = 5, max = 5, message = "corporateId must be between 5 and 5 characters long")
    private Integer productId;

    @NotEmpty(message = "priorityPriceApplication may not be empty")
    @Column(name = "priority")
    private Integer priorityPriceApplication;

    @NotEmpty(message = "cost may not be empty")
    @Column(name = "price")
    private Long cost;

    @Column(name = "curr")
    @NotEmpty(message = "currencyIso may not be empty")
    @Size(min = 3, max = 3, message = "currencyIso must be between 3 and 3 characters long")
    private String currencyIso;

}
