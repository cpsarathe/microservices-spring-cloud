package com.cp.order.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDto {
    private String orderId;
    private BigDecimal amount;
}
