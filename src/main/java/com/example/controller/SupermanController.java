package com.example.controller;

import com.example.entity.Superman;
import com.example.service.treeService.SupermanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 树形结构数据的嵌套封装 测用例
 */
@RestController
public class SupermanController {

    @Autowired
    private SupermanService supermanService;

    @RequestMapping("/getAllSuperman")
    public List getAllSuperman() {
        // supermanService才是重点，接下来演示三种全量嵌套查询的方法
        List<Superman> list = supermanService.getAllSupermanThree();
        return list;
    }
}