package com.ionix.authenticator.controller;

import com.ionix.authenticator.entity.User;
import com.ionix.authenticator.entity.UserLogin;
import com.ionix.authenticator.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateAuth" })
    public UserLogin basicAuth() {
        UserLogin userLogin = new UserLogin();
        userLogin.setStatus("User Correcto!");
        return userLogin;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User userData = userService.findById(id);

        userData.setFirstname(user.getFirstname());
        userData.setLastname(user.getLastname());
        userData.setUsername(user.getUsername());
        userData.setEmail(user.getEmail());

        return userService.save(userData);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
