package com.example.copyBean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyBeanUtilsTest浅 {

    /*实体*/
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person implements Serializable {
        private String name;
        private Integer age;
        private Department department;
    }

    /*实体*/
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Department implements Serializable{
        private String name;
    }

    /*初始化*/
    private static List<Person> list;
    /*初始化*/
    static {
        list = new ArrayList<>();
        list.add(new Person("笑脸", 18, new Department("行政部")));
    }


    public static void main(String[] args) throws Exception {

      /*  *//*浅拷贝： 不额外创建子对象，只是把子对象的引用拷贝过去*//*
        Person bean = list.get(0);
        Person copyBean = new Person();
        //Spring的方法
        BeanUtils.copyProperties(bean,copyBean);
        System.out.println(bean == copyBean);

        System.out.println("==== copyBean的属性 ====");
        System.out.println(copyBean.getName());
        System.out.println(copyBean.getDepartment().getName());

        *//*浅拷贝只是copy属性，后来改变属性之后，被copy的对象的属性不会跟着改变*//*
        bean.setName("哭脸");
        *//*浅拷贝只是copy了引用过去，结果你改变属性之后，被copy的对象的属性也跟着改变*//*
        bean.getDepartment().setName("财务部");

        *//*从测试结果来看，浅拷贝确实在内存中新建了一个Person对象，
        但没有新建department子对象。由于新旧Person的department都指向同一个对象，
        所以会互相影响。我们期望的结果是，在拷贝Person的同时顺便把里面的Department也拷贝一份，也就是深拷贝*//*
        System.out.println("==== sourceBean修改后，copyBean的属性 ====");
        System.out.println(copyBean.getName());
        System.out.println(copyBean.getDepartment().getName());*/


        System.out.println("========================================================================================================");

        /* 方法一：  深拷贝 */
        List<Person> copyList = MyBeanUtils.deepCopy(list);

        /* 方法二：  深拷贝 */
//        ObjectMapper objectMapper = new ObjectMapper();
//        String newListStr = objectMapper.writeValueAsString(list);
//        List<Person> copyList = objectMapper.readValue(newListStr, new TypeReference<List<Person>>() {
//        });

        System.out.println("==== copyBean的属性 ====");
        System.out.println(list.get(0).getName());
        System.out.println(list.get(0).getDepartment().getName());

        list.get(0).setName("哭脸");
        list.get(0).getDepartment().setName("财务部");

        System.out.println("==== sourceBean修改后，copyBean的属性 ====");
        System.out.println(copyList.get(0).getName());

        System.out.println(copyList.get(0).getDepartment().getName());
    }
}
