package com.example.spring监听机制.监听机制优化_commont.service;

import com.example.spring监听机制.监听机制优化_commont.event.Event;
import com.example.spring监听机制.监听机制优化_commont.event.OrderCompletedEvent;
import com.example.spring监听机制.监听机制优化_commont.listener.Listener;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * 短信服务，监听下单事件，下单后发短信通知用户
 */
public class SmsService implements Listener<OrderCompletedEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderCompletedEvent event) {
        System.out.println("下单成功！您的订单号是: " + event.getSource());
        TimeUnit.SECONDS.sleep(2);
    }

    @Override
    public boolean supportsEventType(Event event) {
        return event instanceof OrderCompletedEvent;
    }

}
