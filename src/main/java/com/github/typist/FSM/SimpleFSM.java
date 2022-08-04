package com.github.typist.FSM;

import java.util.*;

/**
 * @author: zhangjl
 * @Date: 22-7-18
 * @Description:
 */
public class SimpleFSM<S, E, C> implements FSM<S, E, C> {
    private final Set<S> FINISHED_STATES;
    private final Map<S, State<S, E, C>> stateMap = new HashMap<>();

    public SimpleFSM(Collection<S> finishedStates) {
        this.FINISHED_STATES = Collections.unmodifiableSet(new HashSet<>(finishedStates));
    }

    @Override
    public S fire(S from, Event<E> event, C ctx) {
        State<S, E, C> fromState = stateMap.get(from);

        return fromState.onEvent(event, ctx).getId();
    }

    @Override
    public void addState(State<S, E, C> state) {
        stateMap.put(state.getId(), state);
    }

    @Override
    public boolean isFinished(S state) {
        return FINISHED_STATES.contains(state);
    }
}
