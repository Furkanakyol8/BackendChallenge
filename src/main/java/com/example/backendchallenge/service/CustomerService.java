package com.example.backendchallenge.service;

import com.example.backendchallenge.dto.*;
import com.example.backendchallenge.model.Customer;

import java.util.List;
import java.util.stream.Stream;

public interface CustomerService {

    DataResponse<Customer> create(CreateCustomerDto customer);

    DataResponse<Customer> update(UpdateCustomerDto customer, int customerId);

    Response delete(int customerId);

    DataResponse<Customer> getById(int customerId);

    DataResponse<List<Customer>> getAll();

    DataResponse<List<CustomerWithOrderIdDto>> getWithOrdersByContainingWord(String word);

    DataResponse<List<Customer>> getCustomersWithoutOrders();
}
