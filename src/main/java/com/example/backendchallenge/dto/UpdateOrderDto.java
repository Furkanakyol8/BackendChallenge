package com.example.backendchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderDto {
    private Date createDate;

    private double totalPrice;

    private int customerId;
}
