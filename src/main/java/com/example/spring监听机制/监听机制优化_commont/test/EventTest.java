package com.example.spring监听机制.监听机制优化_commont.test;


import com.example.spring监听机制.监听机制优化_commont.core.ApplicationContext;
import com.example.spring监听机制.监听机制优化_commont.event.OrderCanceledEvent;
import com.example.spring监听机制.监听机制优化_commont.event.OrderCompletedEvent;
import com.example.spring监听机制.监听机制优化_commont.service.CarService;
import com.example.spring监听机制.监听机制优化_commont.service.RefundService;
import com.example.spring监听机制.监听机制优化_commont.service.SmsService;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;

public class EventTest {

    private static  ApplicationContext applicationContext = new ApplicationContext();

    // 模拟Spring启动，初始化容器并注册bean
    static{
        applicationContext.registerListener(new SmsService());
        applicationContext.registerListener(new CarService());
        applicationContext.registerListener(new RefundService());
    }

    // 模拟下单
    @Test
    public void orderCompletedService() {
        // 扣减库存...

        // 生成订单... orderId=10086

        // 订单流水...

        // 下单成功，发布事件
        applicationContext.publish(new OrderCompletedEvent(10086L));
    }

    // 模拟取消订单
    @Test
    public void orderCanceledService() {
        // 回退库存...

        // 更改订单状态... orderId=10086

        // 订单流水...

        // 订单取消成功，发布事件
        applicationContext.publish(new OrderCanceledEvent(10086L));
    }
}