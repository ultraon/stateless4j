package com.github.oxo42.stateless4j.triggers;

import com.github.oxo42.stateless4j.OutVar;
import com.github.oxo42.stateless4j.delegates.Func2;

public abstract class TriggerBehaviour<S, T> {

    private final T trigger;
    private final Func2<Object[], Boolean> guard;

    protected TriggerBehaviour(T trigger, Func2<Object[], Boolean> guard) {
        this.trigger = trigger;
        this.guard = guard;
    }

    public T getTrigger() {
        return trigger;
    }

    public boolean isGuardConditionMet(Object[] args) {
        return guard.call(args);
    }

    public abstract boolean resultsInTransitionFrom(S source, Object[] args, OutVar<S> dest);
}
