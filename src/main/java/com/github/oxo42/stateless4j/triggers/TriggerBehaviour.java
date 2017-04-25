package com.github.oxo42.stateless4j.triggers;

import com.github.oxo42.stateless4j.OutVar;
import com.github.oxo42.stateless4j.delegates.Func2;
import com.github.oxo42.stateless4j.delegates.FuncBoolean;

public abstract class TriggerBehaviour<S, T> {

    private final T trigger;
    private final Func2<Object[], Boolean> guard;

    protected TriggerBehaviour(final T trigger, final Func2<Object[], Boolean> guard) {
        this.trigger = trigger;
        this.guard = guard;
    }

    protected TriggerBehaviour(final T trigger, final FuncBoolean guard) {
        this.trigger = trigger;
        this.guard = new Func2<Object[], Boolean>() {
            @Override
            public Boolean call(final Object[] arg1) {
                return guard.call();
            }
        };
    }

    public T getTrigger() {
        return trigger;
    }

    public boolean isGuardConditionMet(Object... args) {
        return guard.call(args);
    }

    public abstract boolean resultsInTransitionFrom(S source, Object[] args, OutVar<S> dest);
}
