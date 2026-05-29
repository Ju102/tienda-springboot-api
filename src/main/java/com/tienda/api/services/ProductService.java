package com.tienda.api.services;

import com.tienda.api.entities.Product;
import com.tienda.api.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // Lombok genera un constructor con todos los campos "final". ¡Así se hace la Inyección de Dependencias!
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        // findById devuelve un Optional (previene los NullReferenceException de C#)
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto con ID " + id + " no encontrado"));
    }
}
