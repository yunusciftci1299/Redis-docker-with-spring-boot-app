package com.ciftciler.redis.service;

import com.ciftciler.redis.entity.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);

    List<User> fetchUsers();

    User fetcUserById(Long id);

    boolean deleteUser(Long id);
}
