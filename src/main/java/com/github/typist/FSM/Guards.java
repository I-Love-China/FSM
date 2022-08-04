package com.github.typist.FSM;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author: zhangjl
 * @Date: 22-7-19
 * @Description:
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Guards {
    private static final AbstractState.Guard ALWAYS_TRUE_GUARD = (e, c) -> true;

    @SuppressWarnings("unchecked")
    public static <E, C> AbstractState.Guard<E, C> alwaysTrue() {
        return ALWAYS_TRUE_GUARD;
    }
}
