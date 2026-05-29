package com.tienda.api.controllers;

import com.tienda.api.dtos.SaleRequest;
import com.tienda.api.entities.Sale;
import com.tienda.api.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping("/create")
    public ResponseEntity<Sale> checkout(@RequestBody SaleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.createSale(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Sale>> getUserSales(@PathVariable Integer userId) {
        return ResponseEntity.ok(saleService.getSalesByUser(userId));
    }
}