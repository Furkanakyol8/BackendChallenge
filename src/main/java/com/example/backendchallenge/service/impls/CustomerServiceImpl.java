package com.example.backendchallenge.service.impls;

import com.example.backendchallenge.dto.*;
import com.example.backendchallenge.exception.CustomerNotFoundException;
import com.example.backendchallenge.model.Customer;
import com.example.backendchallenge.repository.CustomerRepository;
import com.example.backendchallenge.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    private ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public DataResponse<Customer> create(CreateCustomerDto customer) {
        Customer customerToCreate = modelMapper.map(customer, Customer.class);
        this.customerRepository.save(customerToCreate);
        return DataResponse.<Customer>dataResponseBuilder().status(true).message("Customer Created").data(customerToCreate).build();
    }
    @Override
    public DataResponse<Customer> update(UpdateCustomerDto customer, int customerId) {
        Customer customerToUpdate = this.getById(customerId).getData();
        Customer updatedCustomer = modelMapper.map(customer, Customer.class);
        updatedCustomer.setId(customerToUpdate.getId());
        this.customerRepository.save(updatedCustomer);
        return DataResponse.<Customer>dataResponseBuilder().status(true).message("Customer Updated. Info: " + customer.getName()).data(updatedCustomer).build();
    }

    @Override
    public Response delete(int customerId) {
        Customer customer = this.getById(customerId).getData();
        this.customerRepository.delete(customer);
        return new Response(true, "Customer Deleted with " + customerId + " id");
    }

    @Override
    public DataResponse<Customer> getById(int customerId) {
        Customer customer = this.customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
        return new DataResponse<>(true, "Customer Shown", customer);
    }

    @Override
    public DataResponse<List<Customer>> getAll() {
        return new DataResponse<>(true, "All Customers Listed", this.customerRepository.findAll());
    }



    public DataResponse<List<CustomerWithOrderIdDto>> getWithOrdersByContainingWord(String word) {
        return new DataResponse<>(true, "Listed '" + word + "'", customerRepository.findWithOrdersByContainingWord(word));
    }

    public DataResponse<List<Customer>> getCustomersWithoutOrders() {
        return new DataResponse<>(true, "Customers Shown Without Orders", customerRepository.findCustomersWithoutOrders());
    }

}
