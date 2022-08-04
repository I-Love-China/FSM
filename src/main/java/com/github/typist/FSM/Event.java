package com.github.typist.FSM;

/**
 * @author: zhangjl
 * @Date: 22-7-18
 * @Description:
 */
public interface Event<E> {
    E getEvent();

    <T> T getPayload(String key);

    void putPayload(String key, Object payload);
}
