package com.github.typist.FSM;

public interface Guard<E, C> {
    boolean evaluate(Event<E> event, C ctx);
}
