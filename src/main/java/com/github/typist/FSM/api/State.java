package com.github.typist.FSM.api;

/**
 * @author: zhangjl
 * @Date: 22-7-18
 * @Description:
 */
public interface State<S, E, C> {
    S getId();

    State<S, E, C> onEvent(Event<E> event, C ctx);

    void addTransition(Transition<S, E, C> transition);
}
