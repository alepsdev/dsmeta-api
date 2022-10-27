package com.alepdev.dsmeta.services;

import com.alepdev.dsmeta.models.SaleModel;
import com.alepdev.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Transactional
    public SaleModel save(SaleModel saleModel) {
        return saleRepository.save(saleModel);
    }

    @Transactional
    public List<SaleModel> findAllSales() {
        return saleRepository.findAll();
    }

}
