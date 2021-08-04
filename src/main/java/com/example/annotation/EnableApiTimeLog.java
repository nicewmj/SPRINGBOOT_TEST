package com.example.annotation;

import com.example.aop.ApiTimeLogAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**

 * 开启接口耗时计算

 这个注解最重要的其实是@Import注解，它是Spring定义的注解，由Spring读取并执行：把对应的Bean实例化并加载到容器。所以
 • @EnableApiTimeLog（其实核心还是@Import）
 • @Import
 • @Component
 这三种形式本质是一样的，都是要把Bean交给Spring管理。

 现在，我把@EnableApiTimeLog加在启动类上，开启AOP：
 */

@Import(ApiTimeLogAspect.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableApiTimeLog {
}
