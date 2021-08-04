package com.example.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoDTO {
    private Long id;

    private String name;

    private Integer password;

    private String sex;

    private Date operateTime;

}
