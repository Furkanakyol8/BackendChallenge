package com.example.backendchallenge.service;

import com.example.backendchallenge.dto.CreateOrderDto;
import com.example.backendchallenge.dto.DataResponse;
import com.example.backendchallenge.dto.Response;
import com.example.backendchallenge.dto.UpdateOrderDto;
import com.example.backendchallenge.model.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    DataResponse<Order> create(CreateOrderDto order);

    DataResponse<Order> update(UpdateOrderDto order, int orderId);

    Response delete(int orderId);

    DataResponse<Order> getById(int orderId);

    DataResponse<List<Order>> getAll();

    DataResponse<List<Order>> getOrdersAfterDate(Date date);
}
