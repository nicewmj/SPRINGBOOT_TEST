package com.example.spring监听机制.监听机制优化_commont.event;

import lombok.Getter;

/**
 * 事件
 */
@Getter
public class Event {

    private Object source;

    public Event(Object source) {
        this.source = source;
    }
}