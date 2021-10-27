package com.ciftciler.redis.repo;

import com.ciftciler.redis.entity.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> fetchUsers();

    User fetcUserById(Long id);

    boolean deleteUser(Long id);
}
