package com.github.oxo42.stateless4j.transitions;

import com.github.oxo42.stateless4j.OutVar;
import com.github.oxo42.stateless4j.delegates.Func2;
import com.github.oxo42.stateless4j.delegates.FuncBoolean;
import com.github.oxo42.stateless4j.triggers.TriggerBehaviour;

public class TransitioningTriggerBehaviour<S, T> extends TriggerBehaviour<S, T> {

    private final S destination;

    public TransitioningTriggerBehaviour(final T trigger, S destination, final Func2<Object[], Boolean> guard) {
        super(trigger, guard);
        this.destination = destination;
    }

    public TransitioningTriggerBehaviour(final T trigger, S destination, final FuncBoolean guard) {
        super(trigger, guard);
        this.destination = destination;
    }

    @Override
    public boolean resultsInTransitionFrom(S source, Object[] args, OutVar<S> dest) {
        dest.set(destination);
        return true;
    }
}
