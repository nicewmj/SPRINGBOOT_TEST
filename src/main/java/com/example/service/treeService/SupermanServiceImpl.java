package com.example.service.treeService;

import com.example.entity.Superman;
import com.example.mapper.SupermanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupermanServiceImpl implements SupermanService {

    @Autowired
    private SupermanMapper supermanMapper;


    /**
     * 第一种方法  递归 耗时: 4954 ms
     * @return
     */
    @Override
    public List<Superman> getAllSuperman() {
        // 查出所有的根节点：孙悟空、贝吉塔
        List<Superman> rootSupermanList = getRootSuperman();

        // 分别查出孙悟空和贝吉塔的孩子，并设置
        for (Superman superman : rootSupermanList) {
            List<Superman> children = queryChildrenByParent(superman);
            superman.setChildren(children);
        }
        // 返回
        return rootSupermanList;
    }



    /**
     * 第二种方法  全量查询 用for去组合树形参数 : ------------ 耗时: 20 ms ----------
     * @return
     */

    @Override
    public List<Superman> getAllSupermanTwo() {
        // 用来存储最终的结果
        List<Superman> list = new ArrayList<>();

        // 先查出全部数据
        List<Superman> data = supermanMapper.selectAll();

        // 双层for循环完成数据组装
        for (Superman left : data) {
            for (Superman right : data) {
                // 如果右边是左边的孩子，就设置进去
                if(left.getId().equals(right.getPid())){
                    left.getChildren().add(right);
                }
            }

            // 只把第1级加到list
            if(left.getPid() == 0){
                list.add(left);
            }
        }
        return list;
    }



    /**
     * 第三种方法  全量查询 用map 去匹配组合树形参数  耗时: 747 ms
     * @return
     */
    @Override
    public List<Superman> getAllSupermanThree() {
        // 用来存储最终的结果
        List<Superman> list =new ArrayList<>();

        // 源数据，需要处理
        List<Superman> data = supermanMapper.selectAll();
        // Map，用来转存List
        Map<Integer,Superman> map =  new HashMap<>();
        for (Superman datum : data) {
            map.put(datum.getId(),datum);

        }

        // 右边child进行for循环找parent
        for (Superman child  : data) {
            if(child.getPid() == 0){
                // 找到第一级（悟空、贝吉塔）
                list.add(child);
            }else {
                // 不是第一级，那么肯定有parent，帮它找到parent，并把它自己设置到parent里
                // hash索引！找爸爸很快！
                Superman superman = map.get(child.getPid());
                superman.getChildren().add(child);
            }
        }

        return list;
    }

    /**
     * 递归查询孩子
     */
    private List<Superman> getRootSuperman() {
        Superman superman = new Superman();
        superman.setPid(0);
        return supermanMapper.select(superman);
    }


    /**
     * 递归查询孩子
     */
    private List<Superman> queryChildrenByParent(Superman parent) {

        // 准备查询条件query
        Superman query = new Superman();
        query.setPid(parent.getId());

        // 查出孩子
        List<Superman> children = supermanMapper.select(query);

        // 查出每个孩子的孩子，并设置
        for (Superman child : children) {
            List<Superman> grandChildren = queryChildrenByParent(child);// 递归
            child.setChildren(grandChildren);
        }
        return children;
    }
}