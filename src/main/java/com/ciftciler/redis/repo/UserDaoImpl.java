package com.ciftciler.redis.repo;

import com.ciftciler.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER";

    @Override
    public boolean saveUser(User user) {
        try {
            redisTemplate.opsForHash().put(KEY,String.valueOf(user.getId()),user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> fetchUsers() {
        List<User> users = redisTemplate.opsForHash().values(KEY);
        return users;
    }

    @Override
    public User fetcUserById(Long id) {
        User user = (User) redisTemplate.opsForHash().get(KEY,String.valueOf(id));
        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY,String.valueOf(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
