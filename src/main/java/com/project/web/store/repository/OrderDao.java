package com.project.web.store.repository;

import com.project.web.store.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Long> {
}
