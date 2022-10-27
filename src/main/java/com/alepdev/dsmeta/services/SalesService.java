package com.alepdev.dsmeta.services;

import com.alepdev.dsmeta.models.SaleModel;
import com.alepdev.dsmeta.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class SalesService {

    @Autowired
     SalesRepository salesRepository;

    @Transactional
    public SaleModel save(SaleModel saleModel) {
        return salesRepository.save(saleModel);
    }
}
