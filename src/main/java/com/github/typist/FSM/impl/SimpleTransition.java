package com.github.typist.FSM.impl;

import com.github.typist.FSM.api.Action;
import com.github.typist.FSM.api.Guard;
import com.github.typist.FSM.api.State;
import com.github.typist.FSM.api.Transition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zhangjl
 * @Date: 22-7-19
 * @Description:
 */
public class SimpleTransition<S, E, C> implements Transition<S, E, C> {
    private final State<S, E, C> to;
    private final E event;
    private final Guard<E, C> guard;
    private List<Action<E, C>> actions = new ArrayList<>();

    public SimpleTransition(E event, State<S, E, C> to, Guard<E, C> guard, List<Action<E, C>> actions) {
        this.to = to;
        this.event = event;
        this.guard = guard;
        this.actions = new ArrayList<>(actions);
    }

    @Override
    public State<S, E, C> getTo() {
        return this.to;
    }

    @Override
    public E getEvent() {
        return this.event;
    }

    @Override
    public Guard<E, C> getGuard() {
        return this.guard;
    }

    @Override
    public void addAction(Action<E, C> action) {
        this.actions.add(action);
    }

    @Override
    public List<Action<E, C>> getActions() {
        return Collections.unmodifiableList(this.actions);
    }
}
