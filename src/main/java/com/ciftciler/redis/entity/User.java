package com.ciftciler.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("product")
public class User implements Serializable {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private int age;
}
