package com.project.web.store.services;

import com.project.web.store.exceptions.NotFoundException;
import com.project.web.store.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.web.store.repository.UserDao;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
    @Override
    public User getBy(Long id) {
        Optional<User> user = userDao.findById(id);
        if (!user.isPresent()) throw new NotFoundException("User with id " + id + " does not exist");
        return user.get();
    }

    @Override
    public User updateUser(Long id, User user){
        userDao.findById(id);
        user.setId(user.getId());
        user.setUserName(user.userName);
        user.setEmail(user.email);
        user.setAddress(user.address);
        return userDao.save(user);
    }

    @Override
    public User createUser(User user) {
        user.setUserName(user.userName);
        user.setEmail(user.email);
        user.setAddress(user.address);
        return userDao.save(user);
    }
    @Override
    public void deleteUser(Long id) {
        Optional<User> user = userDao.findById(id);
        if (!user.isPresent()) throw new NotFoundException("User with id " + id + " does not exist");
        userDao.deleteById(id);
    }

}
