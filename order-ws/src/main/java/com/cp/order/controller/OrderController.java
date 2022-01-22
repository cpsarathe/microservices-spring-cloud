package com.cp.order.controller;

import com.cp.order.dto.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("")
    public ResponseEntity<List<OrderDto>> getOrders(@RequestParam(value = "page", defaultValue = "1") int page,
                                                    @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        OrderDto orderDto1 = new OrderDto();
        orderDto1.setOrderId(UUID.randomUUID().toString());
        orderDto1.setAmount(new BigDecimal(1000));
        OrderDto orderDto2 = new OrderDto();
        orderDto1.setOrderId(UUID.randomUUID().toString());
        orderDto1.setAmount(new BigDecimal(2000));
        orderDtoList.add(orderDto1);
        orderDtoList.add(orderDto2);
        ResponseEntity<List<OrderDto>> responseEntity = new ResponseEntity(orderDtoList, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(value = "/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") String orderId) {
        OrderDto orderDto = new OrderDto();
        orderDto.setAmount(new BigDecimal("100.00"));
        orderDto.setOrderId(orderId);
        ResponseEntity<OrderDto> responseEntity = new ResponseEntity(orderDto, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<OrderDto> placeOrdder(@Valid @RequestBody OrderDto orderDto) {
        OrderDto orderDto1 = new OrderDto();
        orderDto1.setOrderId(UUID.randomUUID().toString());
        orderDto1.setAmount(orderDto.getAmount());
        return new ResponseEntity(orderDto1, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable("id") String orderId) {
        return "cancelled";
    }
}
