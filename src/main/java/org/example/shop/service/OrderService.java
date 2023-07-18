package org.example.shop.service;

import lombok.RequiredArgsConstructor;
import org.example.shop.model.product.Order;
import org.example.shop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public int addOrder1(Order order){
        orderRepository.addOrder(order);
        return 200;
    }
    public List<Order> userOrder1(UUID user_id){
        return orderRepository.userOrder(user_id);
    }
    public void updateOrderStatus(UUID id) {
        orderRepository.updateOrderStatus(id);
    }
    public List<Order> userOrder2(UUID user_id){
        return orderRepository.userHistory(user_id);
    }
    public Order getById(UUID id){
        return orderRepository.getById(id);
    }
    public void updateOrderByType(UUID id, String buyType){
        orderRepository.updateOrderByType(id,buyType);
    }
}
