package com.example.annotation;

import com.example.enumEntiy.Logical;
import com.example.enumEntiy.UserType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 角色权限注解
 * 注意：由于默认权限都是针对用户而言，所以我在PermissionRequired上加了LoginRequired
 */
//@LoginRequired //这是
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface PermissionRequired {
    /**
     * 角色，默认游客权限
     *
     * @return
     */
    UserType[] userType() default {UserType.VISITOR};

    /**
     * 逻辑关系，比如 ADMIN&&TEACHER 或者 ADMIN||TEACHER
     *
     * @return
     */
    Logical logical();
}