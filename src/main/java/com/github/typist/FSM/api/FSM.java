package com.github.typist.FSM.api;

/**
 * @author: zhangjl
 * @Date: 22-7-18
 * @Description:
 */
public interface FSM<S, E, C> {
    S fire(S from, Event<E> event, C ctx);

    void addState(State<S, E, C> state);

    boolean isFinished(S state);
}
