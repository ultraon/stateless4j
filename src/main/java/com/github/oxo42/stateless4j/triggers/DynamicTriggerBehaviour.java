package com.github.oxo42.stateless4j.triggers;

import com.github.oxo42.stateless4j.OutVar;
import com.github.oxo42.stateless4j.delegates.Func2;

public class DynamicTriggerBehaviour<S, T> extends TriggerBehaviour<S, T> {

    private final Func2<Object[], S> destination;

    public DynamicTriggerBehaviour(T trigger, Func2<Object[], S> destination, Func2<Object[], Boolean> guard) {
        super(trigger, guard);
        assert destination != null : "destination is null";
        this.destination = destination;
    }

    @Override
    public boolean resultsInTransitionFrom(S source, Object[] args, OutVar<S> dest) {
        dest.set(destination.call(args));
        return true;
    }
}
