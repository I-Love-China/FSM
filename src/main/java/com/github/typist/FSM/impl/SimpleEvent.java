package com.github.typist.FSM.impl;

import com.github.typist.FSM.api.Event;
import org.apache.commons.collections4.MapUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangjl
 * @Date: 22-7-18
 * @Description:
 */
public class SimpleEvent<E> implements Event<E> {
    private final E event;
    private final Map<String, Object> payload = new HashMap<>();

    public SimpleEvent(E event, Map<String, Object> payload) {
        this.event = event;
        if (MapUtils.isNotEmpty(payload)) {
            this.payload.putAll(payload);
        }
    }

    public SimpleEvent(E event, String key, Object payload) {
        this(event, Collections.singletonMap(key, payload));
    }

    public SimpleEvent(E event) {
        this(event, Collections.emptyMap());
    }

    @Override
    public E getEvent() {
        return event;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getPayload(String key) {
        return (T) payload.get(key);
    }

    @Override
    public void putPayload(String key, Object payload) {
        this.payload.put(key, payload);
    }
}
