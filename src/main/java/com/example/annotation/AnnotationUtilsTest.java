package com.example.annotation;

import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;

/**
 * AnnotationUtils：一个好用的注解工具类
 * 在正式开始之前，我们来了解一下AnnotationUtils。
 * 它是Spring提供的一个注解工具类，提供了获取类上的注解、方法上的注解以及注解属性等便利的操作。
 * 你是否曾经疑惑过：Spring为什么能识别“叠加的注解”？比如，Spring如何识别@RestController？
 *
 * d第一步 定义多个注解并且存在嵌套 FirstLevel SecondLevel ThirdLevel
 * 第二部  使用AnnotationUtils 获取类、方法上的注解以及注解的值
 */

@FirstLevel( value = "first", info = "写在类上面")
public class AnnotationUtilsTest {
    // ------ 使用注解 方法上------
    @FirstLevel(value = "first", info = "写在方法上面")
    public void annotationMethod() {
    }

    public void noAnnotationMethod() {
    }

    public static void main(String[] args) throws Exception {
        // 获取AnnotationUtilsTest的Class，利用AnnotationUtils获取类上的注解
        Class<?> clazz = AnnotationUtilsTest.class;
        FirstLevel firstLevel = AnnotationUtils.findAnnotation(clazz, FirstLevel.class);    // yes
        SecondLevel secondLevel = AnnotationUtils.findAnnotation(clazz, SecondLevel.class); // yes
        ThirdLevel thirdLevel = AnnotationUtils.findAnnotation(clazz, ThirdLevel.class);    // yes
        System.out.println(firstLevel+">>>>>>>  "+secondLevel+">>>>>>>  "+thirdLevel);

        // 获取AnnotationUtilsTest的Class，利用AnnotationUtils获取annotationMethod上的注解
        Method annotationMethod = clazz.getMethod("annotationMethod");
        FirstLevel firstLevel1 = AnnotationUtils.getAnnotation(annotationMethod, FirstLevel.class);     // yes
        SecondLevel secondLevel1 = AnnotationUtils.getAnnotation(annotationMethod, SecondLevel.class);  // yes
        ThirdLevel thirdLevel1 = AnnotationUtils.getAnnotation(annotationMethod, ThirdLevel.class);     // yes
        System.out.println(firstLevel1+">>>>>>>  "+secondLevel1+">>>>>>>  "+thirdLevel1);

        // 获取AnnotationUtilsTest的Class，利用AnnotationUtils获取noAnnotationMethod上的注解
        Method noAnnotationMethod = clazz.getMethod("noAnnotationMethod");
        FirstLevel firstLevel2 = AnnotationUtils.getAnnotation(noAnnotationMethod, FirstLevel.class);   // null
        SecondLevel secondLevel2 = AnnotationUtils.getAnnotation(noAnnotationMethod, SecondLevel.class);// null
        ThirdLevel thirdLevel2 = AnnotationUtils.getAnnotation(noAnnotationMethod, ThirdLevel.class);   // null
        System.out.println(firstLevel2+">>>>>>>  "+secondLevel2+">>>>>>>  "+thirdLevel2);

        Object value = AnnotationUtils.getValue(firstLevel, "value");
        Object info = AnnotationUtils.getValue(firstLevel, "info");
        System.out.println(value+">>>>>>>  "+info);

    }
}
