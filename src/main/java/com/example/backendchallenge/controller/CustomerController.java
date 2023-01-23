package com.example.backendchallenge.controller;

import com.example.backendchallenge.dto.CreateCustomerDto;
import com.example.backendchallenge.dto.UpdateCustomerDto;
import com.example.backendchallenge.model.Customer;
import com.example.backendchallenge.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping
    private ResponseEntity<?> create(@RequestBody CreateCustomerDto customer) {
        return ResponseEntity.ok(customerService.create(customer));
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@RequestBody UpdateCustomerDto customer, @PathVariable int id) {
        return ResponseEntity.ok(customerService.update(customer, id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable int id) {
        return ResponseEntity.ok(customerService.delete(id));
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable int id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @GetMapping
    private ResponseEntity<?> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/withOrders/{word}")
    public ResponseEntity<?> getOrderIdByCustomerName(@PathVariable String word) {
        return ResponseEntity.ok(customerService.getWithOrdersByContainingWord(word));
    }

    @GetMapping("/without-orders")
    public ResponseEntity<?> getCustomersWithoutOrders() {
        //List<Customer> customers = customerService.getCustomersWithoutOrders();
        return ResponseEntity.ok(customerService.getCustomersWithoutOrders());
    }

}
