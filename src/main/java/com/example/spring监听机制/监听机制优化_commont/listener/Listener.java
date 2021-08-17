package com.example.spring监听机制.监听机制优化_commont.listener;

import com.example.spring监听机制.监听机制优化_commont.event.Event;

/**
 * 监听器
 *
 * @param <E>
 */
public interface Listener<E extends Event> {

    /**
     * 事件发生时触发
     *
     * @param event
     */
    void onApplicationEvent(E event);

    /**
     * 监听器是否匹配
     *
     * @param event
     * @return
     */
    boolean supportsEventType(Event event);

}