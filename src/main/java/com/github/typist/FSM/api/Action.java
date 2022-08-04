package com.github.typist.FSM.api;

/**
 * @author: zhangjl
 * @Date: 22-7-18
 * @Description:
 */
public interface Action<E, C> {
    void execute(C ctx, Event<E> event);
}
