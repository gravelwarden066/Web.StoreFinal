package com.project.web.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import com.project.web.store.models.Order;
import com.project.web.store.repository.OrderDao;
import com.project.web.store.services.OrderServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
    @InjectMocks
    OrderServiceImp orderServiceImp;

    @Mock
    OrderDao orderDao;

    @Test
    public void testFindAllOrders() {
        List<Order> list = new ArrayList<Order>();
        Order order1 = new Order(1L, "test1", "test1", 1);
        Order order2 = new Order(2L, "test2", "test2", 2);
        Order order3 = new Order(3L, "test3", "test3", 3);

        list.add(order1);
        list.add(order2);
        list.add(order3);

        when(orderDao.findAll()).thenReturn(list);
        List<Order> orderList = orderServiceImp.getAllOrders();
        assertEquals(2, orderList.size());
        verify(orderDao, times(1)).findAll();
        System.out.println(orderList);
    }
}

