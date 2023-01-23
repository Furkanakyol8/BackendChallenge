package com.example.backendchallenge.repository;

import com.example.backendchallenge.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCreateDateAfter(Date date);
}
