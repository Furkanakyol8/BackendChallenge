package com.example.backendchallenge.repository;

import com.example.backendchallenge.dto.CustomerWithOrderIdDto;
import com.example.backendchallenge.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


//    @Query(value = "select customers.id, customers.name, customers.age, orders.id as \"order_id\" from customers left join orders \n" +
//            "on orders.customer_id = customers.id", nativeQuery = true)
    @Query(value = "Select new com.example.backendchallenge.dto.CustomerWithOrderIdDto(c.id, c.name, c.age, o.id) from " +
            "Order o left join Customer c on o.customer.id = c.id " +
            "WHERE c.name LIKE %:word%")
    List<CustomerWithOrderIdDto> findWithOrdersByContainingWord(String word);


    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.orders o WHERE o.id IS NULL")
    List<Customer> findCustomersWithoutOrders();
}
