package com.example.mapper;

import com.example.entity.UserLogDO;
import org.springframework.stereotype.Component;


@Component
//public interface UserLogMapper extends BaseMapper<UserLogDO> {
public interface UserLogMapper {

    Integer insertUserLog(UserLogDO userLogDO);
}