package com.example.spring监听机制.监听机制优化_commont.service;



import com.example.spring监听机制.监听机制优化_commont.event.Event;
import com.example.spring监听机制.监听机制优化_commont.event.OrderCanceledEvent;
import com.example.spring监听机制.监听机制优化_commont.listener.Listener;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * 退款服务，监听取消订单事件，为用户退款
 */
public class RefundService implements Listener<OrderCanceledEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderCanceledEvent event) {
        System.out.println("退款成功！" + event.getSource() + "元已经退回原账户");
        TimeUnit.SECONDS.sleep(2);
    }

    @Override
    public boolean supportsEventType(Event event) {
        return event instanceof OrderCanceledEvent;
    }
}