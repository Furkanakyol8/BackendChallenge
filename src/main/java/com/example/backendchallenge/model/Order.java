package com.example.backendchallenge.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
