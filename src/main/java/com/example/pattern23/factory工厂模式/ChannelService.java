package com.example.pattern23.factory工厂模式;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 比如，原本工程中有个查询外部商品的接口：
 * 随着对接的第三方平台越来越多，代码开始膨胀（这个Service内部会有两个几乎相同逻辑的外部接口调用流程），
 * 于是我们把淘宝和拼多多抽取到对应的类中：
 */
@Service
public class ChannelService {
   /* @Resource
    private TaobaoClient taobaoClient;
    @Resource
    private PddClient pddClient;

    public Item queryItem(String itemId, Integer platform, boolean useCache){
        // ...
        if(PlatformEnum.TAOBAO.getCode().equals(platform)) {
            // 调用淘宝接口
        } else if(PlatformEnum.PDD.getCode().equals(platform)) {
            // 调用拼多多接口
        }
        // ...
    }*/
}
