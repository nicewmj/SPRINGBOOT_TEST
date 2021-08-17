package com.example.spring监听机制.监听机制优化_commont.service;


import com.example.spring监听机制.监听机制优化_commont.event.Event;
import com.example.spring监听机制.监听机制优化_commont.event.OrderCompletedEvent;
import com.example.spring监听机制.监听机制优化_commont.listener.Listener;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * 物流服务，监听下单事件，用户下单后发货
 */
public class CarService implements Listener<OrderCompletedEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderCompletedEvent event) {
        System.out.println("订单" + event.getSource() + "已经发货！");
        TimeUnit.SECONDS.sleep(2);
    }

    @Override
    public boolean supportsEventType(Event event) {
        return event instanceof OrderCompletedEvent;
    }
}
