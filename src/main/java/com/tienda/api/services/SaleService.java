package com.tienda.api.services;

import com.tienda.api.dtos.SaleRequest;
import com.tienda.api.entities.Product;
import com.tienda.api.entities.Sale;
import com.tienda.api.entities.User;
import com.tienda.api.repositories.ProductRepository;
import com.tienda.api.repositories.SaleRepository;
import com.tienda.api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    // @Transactional es el equivalente a usar una TransactionScope en .NET.
    // Si algo falla a mitad de camino, se hace un Rollback automático en SQL Server.
    @Transactional
    public Sale createSale(SaleRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        BigDecimal total = product.getPrice().multiply(new BigDecimal(request.getQuantity()));

        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setUser(user);
        sale.setQuantity(request.getQuantity());
        sale.setTotal(total);
        sale.setSaleDate(LocalDateTime.now());

        // Guardar en SQL Server (Equivalente a _context.SaveChanges())
        return saleRepository.save(sale);
    }

    public List<Sale> getSalesByUser(Integer userId) {
        return saleRepository.findByUserId(userId);
    }
}
