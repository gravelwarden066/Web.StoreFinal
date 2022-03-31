package com.project.web.store.services;

import com.project.web.store.exceptions.NotFoundException;
import com.project.web.store.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.web.store.repository.OrderDao;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    @Override
    public Order getBy(Long id) {
        Optional<Order> order = orderDao.findById(id);
        if (!order.isPresent()) throw new NotFoundException("Order with id " + id + " does not exist");
        return order.get();
    }

    @Override
    public Order createOrder(Order order) {
        order.setUserName(order.userName);
        order.setProductName(order.productName);
        order.setQuantity(order.quantity);
        return orderDao.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        orderDao.findById(id);
        order.setUserName(order.userName);
        order.setProductName(order.productName);
        order.setQuantity(order.quantity);
        orderDao.save(order);
        return order;
    }


    @Override
    public void deleteOrder(Long id) {
        Optional<Order> order = orderDao.findById(id);
        if (!order.isPresent()) throw new NotFoundException("Order with id " + id + " does not exist");
        orderDao.deleteById(id);
    }
}
