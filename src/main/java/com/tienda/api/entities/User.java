package com.tienda.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USUARIOS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer id;

    @Column(name = "NOMBRE_COMPLETO", nullable = false, length = 100)
    private String fullName;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "USER_PASSWORD", nullable = false, length = 100)
    private String password;

    @Column(name = "DIRECCION", nullable = false, length = 100)
    private String address;
}