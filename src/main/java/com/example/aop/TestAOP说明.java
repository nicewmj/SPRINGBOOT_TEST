package com.example.aop;

public class TestAOP说明 {
    /**
    *   <dependency>
     *     <groupId>org.springframework.boot</groupId>
     *     <artifactId>spring-boot-starter-aop</artifactId>
     *  </dependency>
     *
     *
     *AOP相信大家并不陌生，毕竟Spring除了IOC，最被人津津乐道的就是AOP。要利用AOP完成一个需求，通常包含以下几个部分：
     * • SpringBoot项目导入spring-boot-starter-aop依赖
     * • 编写切面类
     * • 类上加@Aspect注解，表明这是一个切面类
     * • 类上加@Component，把切面交给Spring管理（我们要切的Controller/Service都是Spring容器的，切面要对它们起作用，就必须同样进入容器）
     * • 类内部配置切点表达式，比如@Pointcut("execution(* com.bravo.demo.controller.*.*(..))") 表示对com.bravo.demo.controller包下所有方法进行增强
     * • 类内部编写增强逻辑，通常使用@Before、@Around声明这是一个增强，不同的注解增强的方式不同，比如@Before前置增强、@Around环绕增强
     *
     *通常来说，我们只关心一下几点：
     * • 接口URL：请求哪个接口
     * • 类名方法：我应该去哪个类、哪个方法排查
     * • 请求参数：引发问题的参数是什么（方便复现问题）
     * • 远程地址（可有可无）
     * • 接口耗时
     *
    */

/**
 *
 * ApiTimeLogAspect 校验所有controller 类方法的耗时时间
 *ApiLogAspect          用于打印请求参数、返回值、接口耗时
 *
 */


}
