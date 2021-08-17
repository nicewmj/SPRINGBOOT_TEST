package com.example.spring监听机制.监听机制优化_commont.event;


/**
 * 退单事件
 */
public class OrderCanceledEvent extends Event {
    public OrderCanceledEvent(Object source) {
        super(source);
    }
}