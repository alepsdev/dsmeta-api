package com.alepdev.dsmeta.services;

import com.alepdev.dsmeta.models.SaleModel;
import com.alepdev.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Transactional
    public SaleModel save(SaleModel saleModel) {
        return saleRepository.save(saleModel);
    }

    @Transactional
    public Page<SaleModel> findAllSales(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    @Transactional
    public Page<SaleModel> findSalesByDate(String minDate, String maxDate, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        return saleRepository.findSalesByDate(min, max, pageable);
    }

}
