package com.project.web.store.services;

import com.project.web.store.models.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public interface OrderService {

    List<Order> getAllOrders();

    Order getBy(Long id);

    Order createOrder(Order order);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);

}
