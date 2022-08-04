package com.github.typist.FSM.impl;

import com.github.typist.FSM.api.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * @author: zhangjl
 * @Date: 22-7-18
 * @Description:
 */
public abstract class AbstractState<S, E, C> implements State<S, E, C> {
    private final S STATE_ID;
    private final Map<E, List<Transition<S, E, C>>> evtTransitions = new HashMap<>();

    protected AbstractState(S id) {
        this.STATE_ID = id;
    }

    @Override
    public S getId() {
        return this.STATE_ID;
    }

    @Override
    public State<S, E, C> onEvent(Event<E> event, C ctx) {
        Transition<S, E, C> actualTransition = null;
        for (Transition<S, E, C> transition : evtTransitions.get(event.getEvent())) {
            if (transition.getGuard().evaluate(event, ctx)) {
                actualTransition = transition;
                break;
            }
        }

        assert null != actualTransition : "no suitable transition for State: " + STATE_ID + " on: " + event.getEvent();

        final Transition<S, E, C> finalTransition = actualTransition;

//        return tx.execute((txStatus) -> {
        if (CollectionUtils.isNotEmpty(finalTransition.getActions())) {
            finalTransition.getActions().forEach(a -> a.execute(ctx, event));
        }

        return finalTransition.getTo();
//                }
//        );
    }

    @Override
    public void addTransition(Transition<S, E, C> transition) {
        List<Transition<S, E, C>> transitions = evtTransitions.computeIfAbsent(transition.getEvent(), k -> new ArrayList<>());

        transitions.add(transition);
    }

    protected final void addTransition(E event, State<S, E, C> to, Guard<E, C> guard, List<Action<E, C>> actions) {
        addTransition(new SimpleTransition<S, E, C>(event, to, guard, actions));
    }

    @SafeVarargs
    protected final void addTransition(E event, State<S, E, C> to, Guard<E, C> guard, Action<E, C>... actions) {
        if (ArrayUtils.isEmpty(actions)) {
            return;
        }

        addTransition(new SimpleTransition<>(event, to, guard, Arrays.asList(actions)));
    }
}
