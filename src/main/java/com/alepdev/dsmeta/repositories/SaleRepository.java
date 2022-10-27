package com.alepdev.dsmeta.repositories;

import com.alepdev.dsmeta.models.SaleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface SaleRepository extends JpaRepository<SaleModel, UUID> {

    @Query("SELECT obj FROM SaleModel obj WHERE obj.dateSale BETWEEN :min AND :max ORDER BY obj.amount DESC")
    Page<SaleModel> findSalesByDate(LocalDate min, LocalDate max, Pageable pageable);
}
