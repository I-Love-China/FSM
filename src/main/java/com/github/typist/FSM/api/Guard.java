package com.github.typist.FSM.api;

public interface Guard<E, C> {
    boolean evaluate(Event<E> event, C ctx);
}
