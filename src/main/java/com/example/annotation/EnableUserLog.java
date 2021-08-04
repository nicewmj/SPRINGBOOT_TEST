package com.example.annotation;

import com.example.aop.UserLogAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启用户日志记录（还需要在相关方法上添加{@link UserLog}）
 *
 * @author sunting
 * @date 2021-02-11 14:11
 */
@Import(UserLogAspect.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableUserLog {
}