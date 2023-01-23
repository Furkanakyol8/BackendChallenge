package com.example.backendchallenge.controller;

import com.example.backendchallenge.dto.CreateOrderDto;
import com.example.backendchallenge.dto.UpdateOrderDto;
import com.example.backendchallenge.model.Order;
import com.example.backendchallenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;


    @Autowired
    public OrderController(OrderService orderService) {this.orderService = orderService;}

    @GetMapping("/date")
    public ResponseEntity<?> getOrdersAfterDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return ResponseEntity.ok(orderService.getOrdersAfterDate(date));
    }

    @PostMapping
    private ResponseEntity<?> create(@RequestBody CreateOrderDto order) {
        return ResponseEntity.ok(orderService.create(order));
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@RequestBody UpdateOrderDto order, @PathVariable int id) {
        return ResponseEntity.ok(orderService.update(order, id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable int id) {
        return ResponseEntity.ok(orderService.delete(id));
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @GetMapping
    private ResponseEntity<?> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

}
