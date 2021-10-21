package com.ionix.authenticator.service;

import com.ionix.authenticator.dao.IUserDao;
import com.ionix.authenticator.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
