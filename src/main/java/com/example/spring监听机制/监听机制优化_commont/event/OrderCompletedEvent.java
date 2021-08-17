package com.example.spring监听机制.监听机制优化_commont.event;

/**
 * 下单事件
 */
public class OrderCompletedEvent extends Event {
    public OrderCompletedEvent(Long source) {
        super(source);
    }
}