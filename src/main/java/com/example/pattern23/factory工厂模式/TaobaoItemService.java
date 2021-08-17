package com.example.pattern23.factory工厂模式;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TaobaoItemService {
  /*  @Resource
    private TaobaoClient taobaoClient;
    
    public Item queryItem(String itemId){
        // 省略具体代码
    }*/

  @Service
  public class PddItemService {
   /* @Resource
    private PddClient pddClient;

    public Item queryItem(String itemId){
        // 省略具体代码
    }*/
  }
}

