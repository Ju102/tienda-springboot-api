package com.tienda.api.repositories;
import com.tienda.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {}
    // El primer parámetro es la Entidad (Product)
    // El segundo parámetro es el tipo de dato de la Clave Primaria (Integer)
