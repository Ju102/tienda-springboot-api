package com.tienda.api.controllers;

import com.tienda.api.entities.Product;
import com.tienda.api.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Equivalente a [ApiController]
@RequestMapping("api/products") // Equivalente a [Route("api/[controller]")]
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // Equivalente a [HttpGet]
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // Equivalente a [HttpGet("{id}")]
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        // @PathVariable mapea el {id} de la URL al parámetro del method
        return ResponseEntity.ok(productService.getProductById(id));
    }
}
