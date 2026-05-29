package com.tienda.api.dtos;

import lombok.Data;

@Data
public class SaleRequest {
    private Integer productId;
    private Integer userId;
    private Integer quantity;
}
