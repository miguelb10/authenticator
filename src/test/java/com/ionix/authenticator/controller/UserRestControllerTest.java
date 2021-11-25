package com.ionix.authenticator.controller;

import com.ionix.authenticator.entity.User;
import com.ionix.authenticator.service.IUserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

class UserRestControllerTest {

    @Mock
    private IUserService service;

    @InjectMocks
    private UserRestController userRestController;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void basicAuth() {

    }

    @Test
    void getAllUsers() {
        List<User> response = new ArrayList<>();
        response = userRestController.getAllUsers();
        Assertions.assertThat(response).isNotNull();
    }

    @Test
    void getUserById() {
        User data = new User();
        data.setId(1L);
        data.setEmail("test@gmail.com");
        data.setUsername("miguelbp");
        data.setFirstname("Miguel");
        data.setLastname("Blas");

        Mockito.when(userRestController.getUserById(ArgumentMatchers.any())).thenReturn(data);

        User response = userRestController.getUserById(1L);
        Assertions.assertThat(response).isNotNull();
    }

    @Test
    void createUser() {
        User data = new User();
        data.setId(1L);
        data.setEmail("test@gmail.com");
        data.setUsername("miguelbp");
        data.setFirstname("Miguel");
        data.setLastname("Blas");

        Mockito.when(userRestController.createUser(ArgumentMatchers.any())).thenReturn(data);

        User response = userRestController.createUser(data);
        Assertions.assertThat(response).isNotNull();
    }

    //@Test
    void updateUser() {
        User data = new User();
        data.setEmail("test@gmail.com");
        data.setUsername("miguelbp");
        data.setFirstname("Miguel");
        data.setLastname("Blas");

        Mockito.when(userRestController.updateUser(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(data);

        User response = userRestController.updateUser(1L, data);
        Assertions.assertThat(response).isNotNull();
    }

    @Test
    void deleteUser() {
        userRestController.deleteUser(1L);
    }
}