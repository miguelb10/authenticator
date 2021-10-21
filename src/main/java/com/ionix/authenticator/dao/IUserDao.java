package com.ionix.authenticator.dao;

import com.ionix.authenticator.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long> {
}
