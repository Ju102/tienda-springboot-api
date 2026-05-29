package com.tienda.api.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "PRODUCTOS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String name;

    @Column(name = "CATEGORIA", nullable = false, length = 20)
    private String category;

    @Column(name = "PRECIO", nullable = false)
    private BigDecimal price;
}
