package com.github.typist.FSM;

import java.util.List;

/**
 * @author: zhangjl
 * @Date: 22-7-19
 * @Description:
 */

public interface Transition<S, E, C> {
    State<S, E, C> getTo();

    E getEvent();

    AbstractState.Guard<E, C> getGuard();

    void addAction(Action<E, C> action);

    List<Action<E, C>> getActions();
}
