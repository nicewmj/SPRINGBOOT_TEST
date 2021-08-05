package com.example.mapper;

import com.example.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

   Integer insert(User userInfo);

    User selectOne(User userInfo);
}
