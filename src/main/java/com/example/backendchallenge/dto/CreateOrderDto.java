package com.example.backendchallenge.dto;

import com.example.backendchallenge.model.Order;
import com.example.backendchallenge.model.Customer;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateOrderDto {
    private Date createDate;

    private double totalPrice;

    private int customerId;

    public static Order from(CreateOrderDto createOrderDto){
        return Order.builder()
                .createDate(createOrderDto.getCreateDate())
                .totalPrice(createOrderDto.getTotalPrice())
                .customer(Customer.builder().id(createOrderDto.getCustomerId()).build())
                .build();
    }
}
