package com.github.oxo42.stateless4j.triggers;

import com.github.oxo42.stateless4j.OutVar;
import com.github.oxo42.stateless4j.delegates.Func2;
import com.github.oxo42.stateless4j.delegates.FuncBoolean;

public class IgnoredTriggerBehaviour<TState, TTrigger> extends TriggerBehaviour<TState, TTrigger> {

    public IgnoredTriggerBehaviour(final TTrigger trigger, final Func2<Object[], Boolean> guard) {
        super(trigger, guard);
    }

    public IgnoredTriggerBehaviour(final TTrigger trigger, final FuncBoolean guard) {
        super(trigger, guard);
    }

    @Override
    public boolean resultsInTransitionFrom(TState source, Object[] args, OutVar<TState> dest) {
        return false;
    }
}
