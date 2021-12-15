package com.example.controller;

import com.example.annotation.MyAfter;
import com.example.annotation.MyBefore;
import com.example.annotation.MyTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * | controller
 *      -EmployeeDAOTest
 *
 *  测试读取注解 并实现操作
 *
 *      1;获取class文件，并实例化对象     EmployeeDAOTest.class;  classzz.newInstance();
 *      2;通过class文件获取 所有方法      classzz.getMethods()
 *      3;便利所有方法，判断方法上使用哪些注解          method.isAnnotationPresent(MyBefore.class)
 */
public class MyJunitFrameWork {
    /**
     * 这个就是注解三部曲中最重要的：读取注解并操作
     * 相当于我们使用Junit时看不见的那部分（在隐秘的角落里帮我们执行标注了@Test的方法）
     */
    public static void main(String[] args) throws Exception {

        // 1.先找到测试类的字节码：EmployeeDAOTest
        Class<EmployeeDAOTest> classzz = EmployeeDAOTest.class;
        EmployeeDAOTest obj = classzz.newInstance();

        // 2.获取EmployeeDAOTest类中所有的公共方法
        Method[] methods = classzz.getMethods();

        // 3.迭代出每一个Method对象，判断哪些方法上使用了@MyBefore/@MyAfter/@MyTest注解
        List<Method> afterList = new ArrayList<>();
        List<Method> beforeList = new ArrayList<>();
        List<Method> testList = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyBefore.class)) {
                beforeList.add(method);
            } else if (method.isAnnotationPresent(MyAfter.class)) {
                afterList.add(method);
            } else if (method.isAnnotationPresent(MyTest.class)) {
                testList.add(method);
            }
        }

        // 执行方法测试
        for (Method method : testList) {
            // 先执行@MyBefore的方法
            for (Method beforeMethod : beforeList) {
                beforeMethod.invoke(obj);
            }
            // zai执行@MyTest的方法
            method.invoke(obj);
            // 最后执行@MyAfter的方法
            for (Method afterList1 : afterList) {
                afterList1.invoke(obj);
            }
        }
    }
}
