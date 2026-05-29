package com.tienda.api.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "VENTAS")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VENTA")
    private Integer id;

    // Relación con Productos: Muchas ventas corresponden a un Producto
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRODUCTO", nullable = false) // Esta es la FK en tu SQL Server
    private Product product;

    // Relación con Usuarios: Muchas ventas corresponden a un Usuario
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USUARIO", nullable = false) // Esta es la FK en tu SQL Server
    private User user;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer quantity;

    @Column(name = "TOTAL", nullable = false)
    private BigDecimal total;

    @Column(name = "FECHA", nullable = false)
    private LocalDateTime saleDate;
}