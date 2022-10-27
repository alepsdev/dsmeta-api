package com.alepdev.dsmeta.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_sales")
public class SaleModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idSale;

    @Column(nullable = false)
    private String sellerName;

    @Column(nullable = false)
    private Integer visited;

    @Column(nullable = false)
    private Integer deals;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate dateSale;
}
