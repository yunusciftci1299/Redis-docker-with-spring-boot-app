package com.ciftciler.redis.controller;

import com.ciftciler.redis.entity.User;
import com.ciftciler.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user){
        return userService.saveUser(user) ? ResponseEntity.ok("User created succesfully.")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping
    public ResponseEntity<List<User>> fetchUsers(){
        List<User> users = userService.fetchUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> fetcUserById(@PathVariable("id") Long id){
        User user=userService.fetcUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id) ? ResponseEntity.ok("User deleted succesfully.")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
