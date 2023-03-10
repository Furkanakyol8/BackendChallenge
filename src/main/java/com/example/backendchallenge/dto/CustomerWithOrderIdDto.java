package com.example.backendchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerWithOrderIdDto {

    private int id;

    private String name;

    private int age;

    private int orderId;
}
