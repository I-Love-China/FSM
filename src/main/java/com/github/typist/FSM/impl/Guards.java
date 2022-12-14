package com.github.typist.FSM.impl;

import com.github.typist.FSM.api.Guard;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author: zhangjl
 * @Date: 22-7-19
 * @Description:
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Guards {
    private static final Guard ALWAYS_TRUE_GUARD = (e, c) -> true;

    @SuppressWarnings("unchecked")
    public static <E, C> Guard<E, C> alwaysTrue() {
        return ALWAYS_TRUE_GUARD;
    }
}
