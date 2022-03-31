package com.project.web.store.repository;

import com.project.web.store.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {}

