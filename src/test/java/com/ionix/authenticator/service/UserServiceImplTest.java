package com.ionix.authenticator.service;

import com.ionix.authenticator.dao.IUserDao;
import com.ionix.authenticator.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Mock
    private IUserDao iUserDao;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    List<User> userList;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userList = new ArrayList<>();
        user = new User();

        user.setId(1L);
        user.setEmail("test@gmail.com");
        user.setUsername("miguelbp");
        user.setFirstname("Miguel");
        user.setLastname("Blas");

        userList.add(user);
    }

    @Test
    void findAll() {
        Mockito.when(iUserDao.findAll()).thenReturn(userList);
        List<User> userListData =userService.findAll();
        assertEquals(userListData,userList);
        Mockito.verify(iUserDao, Mockito.times(1)).findAll();
    }

    //@Test
    void findById() {
        Mockito.when(iUserDao.findById(1L).orElse(null)).thenReturn(user);
        User userData = userService.findById(1L);
        assertEquals(userData,user);
    }

    @Test
    void save() {
        Mockito.when(iUserDao.save(user)).thenReturn(user);
        User userData =userService.save(user);
        assertEquals(userData,user);
    }

    @Test
    void delete() {
        userService.delete(1L);
    }
}