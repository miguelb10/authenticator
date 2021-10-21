package com.ionix.authenticator.service;

import com.ionix.authenticator.entity.User;

import java.util.List;

public interface IUserService {

    public List<User> findAll();

    public User findById(Long id);

    public User save(User user);

    public void delete(Long id);
}
