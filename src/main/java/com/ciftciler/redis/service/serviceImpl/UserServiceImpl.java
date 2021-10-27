package com.ciftciler.redis.service.serviceImpl;

import com.ciftciler.redis.entity.User;
import com.ciftciler.redis.repo.UserDao;
import com.ciftciler.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<User> fetchUsers() {
        return userDao.fetchUsers();
    }

    @Override
    public User fetcUserById(Long id) {
        return userDao.fetcUserById(id);
    }

    @Override
    public boolean deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}
