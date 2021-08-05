package com.example.entity;

import com.example.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("t_jpa_user")
public class User implements Serializable {

    private String id;
    private String name;
    private String password;
    private String gender;
    private Integer age;
    private String address;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;
    private Integer userType;

}