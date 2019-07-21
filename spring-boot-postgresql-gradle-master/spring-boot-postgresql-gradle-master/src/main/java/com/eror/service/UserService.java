package com.eror.service;

import com.eror.model.User;

import java.util.List;

public interface UserService {
    User find(int id);

    User findByUsername(String username);

    List<User> findAll();

    User create(User object);

    User update(int id, User object);

    boolean delete(int id);

    boolean deleteAll();
}
