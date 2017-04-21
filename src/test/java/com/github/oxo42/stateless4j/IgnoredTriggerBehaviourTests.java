package com.github.oxo42.stateless4j;

import com.github.oxo42.stateless4j.delegates.Func2;
import com.github.oxo42.stateless4j.delegates.FuncBoolean;
import com.github.oxo42.stateless4j.triggers.IgnoredTriggerBehaviour;
import org.junit.Test;

import static org.junit.Assert.*;

public class IgnoredTriggerBehaviourTests {

    public static FuncBoolean returnTrue = new FuncBoolean() {

        @Override
        public boolean call() {
            return true;
        }
    };

    public static FuncBoolean returnFalse = new FuncBoolean() {

        @Override
        public boolean call() {
            return false;
        }
    };

    @Test
    public void StateRemainsUnchanged() {
        IgnoredTriggerBehaviour<State, Trigger> ignored = new IgnoredTriggerBehaviour<>(Trigger.X, toUntypedGuard(returnTrue));
        assertFalse(ignored.resultsInTransitionFrom(State.B, new Object[0], new OutVar<State>()));
    }

    @Test
    public void ExposesCorrectUnderlyingTrigger() {
        IgnoredTriggerBehaviour<State, Trigger> ignored = new IgnoredTriggerBehaviour<>(Trigger.X, toUntypedGuard(returnTrue));
        assertEquals(Trigger.X, ignored.getTrigger());
    }

    @Test
    public void WhenGuardConditionFalse_IsGuardConditionMetIsFalse() {
        IgnoredTriggerBehaviour<State, Trigger> ignored = new IgnoredTriggerBehaviour<>(Trigger.X, toUntypedGuard(returnFalse));
        assertFalse(ignored.isGuardConditionMet(null));
    }

    @Test
    public void WhenGuardConditionTrue_IsGuardConditionMetIsTrue() {
        IgnoredTriggerBehaviour<State, Trigger> ignored = new IgnoredTriggerBehaviour<>(Trigger.X, toUntypedGuard(returnTrue));
        assertTrue(ignored.isGuardConditionMet(null));
    }

    public static Func2<Object[], Boolean> toUntypedGuard(final FuncBoolean guard) {
        return new Func2<Object[], Boolean>() {
            @Override
            public Boolean call(Object[] arg1) {
                return guard.call();
            }
        };
    }
}
