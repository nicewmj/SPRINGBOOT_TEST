package com.example.controller;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

/**
 * @CrossOrigin 注解 实现前后端跨域问题
 * 测试vue请求
 */
@Controller
public class HelloController {

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/hello")
    public User hello() {
//        return "hello";
        User user = new User();
        user.setName("bravo");
        user.setAge(18);
        user.setAddress("wenzhou");
        return user;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/testVueJson")
    public User testVueResponseBody(@RequestBody User user){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(user.getDate1());
        String format1 = simpleDateFormat.format(user.getDate2());


        User user1 = new User();
        user.setName("bravo");
        user.setAge(18);
        user.setAddress("wenzhou");
        return user1;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/testVueUrl")
    public String testVueResponseUrl(@Param("name") String name,@Param("age") String age){
        System.out.println("收到参数了,参数为 = "+ name+"======"+age);
        return "收到参数了,参数为 = ";
    }

    @RequestMapping("/import")
    public String importTets() {
        return "import";
    }

}
