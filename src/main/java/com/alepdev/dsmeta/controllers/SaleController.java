package com.alepdev.dsmeta.controllers;

import com.alepdev.dsmeta.dtos.SaleDTO;
import com.alepdev.dsmeta.models.SaleModel;
import com.alepdev.dsmeta.services.SaleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @PostMapping
    public ResponseEntity<Object> saveSale(@RequestBody @Valid SaleDTO saleDTO) {
        var saleModel = new SaleModel();
        BeanUtils.copyProperties(saleDTO, saleModel);

        if(saleModel.getDateSale() == null) {
            saleModel.setDateSale(LocalDate.now(ZoneId.of("UTC-3")));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.save(saleModel));
    }

    @GetMapping
    public List<SaleModel> findAll(){
        return saleService.findAllSales();
    }
}
