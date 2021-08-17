package com.example.controller;


import com.example.annotation.LoginRequired;
import com.example.annotation.PermissionRequired;
import com.example.commom.Result;
import com.example.commom.WebConstant;
import com.example.entity.User;
import com.example.enumEntiy.ExceptionCodeEnum;
import com.example.enumEntiy.Logical;
import com.example.enumEntiy.UserType;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 简单的权限测试controller
 */
@RestController
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HttpSession session;


    /**
     * 测试
     * @param userInfo
     * @return
     */
    @PostMapping("/register")
    public Result<User> register(@RequestBody User userInfo) {
        int rows = userMapper.insert(userInfo);
        if (rows > 0) {
            return Result.success(userInfo);
        }
        return Result.error("插入失败");
    }

    /**
     * 登录
     * @param userInfo
     * @return
     */
    @PostMapping("/login")
    public Result<User> login(@RequestBody User loginInfo) {
        // 用的是MyBatis-Plus
       /* LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(User::getName, loginInfo.getName());
        lambdaQuery.eq(User::getPassword, loginInfo.getPassword());*/
        User userParams = new User();
        userParams.setName(loginInfo.getName());
        userParams.setPassword(loginInfo.getPassword());
        User userResult = userMapper.selectOne(userParams);
        if (userResult == null) {
            return Result.error("用户名或密码错误");
        }
        session.setAttribute(WebConstant.CURRENT_USER_IN_SESSION, userResult);
        return Result.success(userResult);

    }


    /**
     * 有注解 @LoginRequired  免密登录
     * @param userInfo
     * @return
     */
    @LoginRequired
    @GetMapping("/needLogin")
    public Result<String> needLogin() {
        return Result.error(ExceptionCodeEnum.NEED_LOGIN,"if you see this, you are logged in.");
    }


    /**
     * 控制权限需要先登录
     * @param userInfo
     * @return
     */
    @GetMapping("/needNotLogin")
    public Result<String> needNotLogin() {
        return Result.error(ExceptionCodeEnum.PERMISSION_DENY,"if you see this, you are logged in.");

    }

    /**
     * 需要权限
     * @return
     */
    @LoginRequired
    @PermissionRequired(userType = {UserType.ADMIN,UserType.TEACHER}, logical = Logical.OR)
    @GetMapping("/needPermission")
    public Result<String> needPermission() {
        return Result.success("if you see this, you has the permission.");

    }
}
