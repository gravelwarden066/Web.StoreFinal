package com.project.web.store.services;

import com.project.web.store.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface UserService {

    @Autowired
    List<User> getAllUsers();

    User getBy(Long id);

    User updateUser(Long id, User user);

    User createUser(User user);

    void deleteUser(Long id);

}
