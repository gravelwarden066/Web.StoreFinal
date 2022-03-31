package com.project.web.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import com.project.web.store.models.User;
import com.project.web.store.repository.UserDao;
import com.project.web.store.services.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @InjectMocks
    UserServiceImp userServiceImp;

    @Mock
    UserDao userDao;



    @Test
    public void testFindAllUsers() {
        List<User> list = new ArrayList<User>();
        User userOne = new User(1L,"Test1","test1@gmail.com","Example Street 1");
        User userTwo = new User(2L,"Test2","test2@gmail.com","Example Street 2");
        User userThree = new User(3L,"Test3","test3@gmail.com","Example Street 3");

        list.add(userOne);
        list.add(userTwo);
        list.add(userThree);

        when(userDao.findAll()).thenReturn(list);

        //test
        List<User> userList = userServiceImp.getAllUsers();

        assertEquals(2, userList.size());
        verify(userDao, times(1)).findAll();
        System.out.println("Expected result : Test1 Test2 Test3\n "
                + "Actual Result : " + userOne.getUserName() + " " + userTwo.getUserName() + " " + userThree.getUserName());

    }
}