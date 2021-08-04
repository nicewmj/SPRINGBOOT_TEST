package com.example.service.treeService;

import com.example.entity.Superman;

import java.util.List;

public interface SupermanService {
    /**
     * 第一种方法  递归
     * @return
     */
    List<Superman> getAllSuperman();

    /**
     * 第二种方法  全量查询 用for去组合树形参数
     * @return
     */
    List<Superman> getAllSupermanTwo();

    /**
     * 第三种方法  全量查询 用map 去匹配组合树形参数
     * @return
     */
    List<Superman> getAllSupermanThree();
}
