package com.example.backendchallenge.service.impls;

import com.example.backendchallenge.dto.CreateOrderDto;
import com.example.backendchallenge.dto.DataResponse;
import com.example.backendchallenge.dto.Response;
import com.example.backendchallenge.dto.UpdateOrderDto;
import com.example.backendchallenge.exception.OrderNotFoundException;
import com.example.backendchallenge.model.Order;
import com.example.backendchallenge.repository.OrderRepository;
import com.example.backendchallenge.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    public DataResponse<List<Order>> getOrdersAfterDate(Date date) {
        return new DataResponse<>(true, "All Orders Listed with date", orderRepository.findByCreateDateAfter(date));
    }

    @Override
    public DataResponse<Order> create(CreateOrderDto createOrderDto) {
        Order orderToCreate= CreateOrderDto.from(createOrderDto);
        this.orderRepository.save(orderToCreate);
        return DataResponse.<Order>dataResponseBuilder().status(true).message("Order Created").data(orderToCreate).build();
    }

    @Override
    public DataResponse<Order> update(UpdateOrderDto order, int orderId) {
        Order orderToUpdate = this.getById(orderId).getData();
        Order updatedOrder = modelMapper.map(order, Order.class);
        updatedOrder.setId((orderToUpdate.getId()));
        this.orderRepository.save(updatedOrder);
        return DataResponse.<Order>dataResponseBuilder().status(true).message("Order Updated. Info: " + orderId).data(updatedOrder).build();
    }

    @Override
    public Response delete(int orderId) {
        Order order = this.getById(orderId).getData();
        this.orderRepository.delete(order);
        return new Response(true, "Order Deleted with" + orderId + " id");
    }

    @Override
    public DataResponse<Order> getById(int orderId) {
        Order order = this.orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        return new DataResponse<>(true, "Order Shown", order);
    }

    @Override
    public DataResponse<List<Order>> getAll() {
        return new DataResponse<>(true, "All Orders Listed", orderRepository.findAll());
    }
}
