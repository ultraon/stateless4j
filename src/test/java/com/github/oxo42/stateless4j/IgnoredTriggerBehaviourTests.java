package com.github.oxo42.stateless4j;

import com.github.oxo42.stateless4j.delegates.FuncBoolean;
import com.github.oxo42.stateless4j.triggers.IgnoredTriggerBehaviour;
import org.junit.Test;

import static org.junit.Assert.*;

public class IgnoredTriggerBehaviourTests {

    final static FuncBoolean RETURN_TRUE = new FuncBoolean() {

        @Override
        public boolean call() {
            return true;
        }
    };

    final static FuncBoolean RETURN_FALSE = new FuncBoolean() {

        @Override
        public boolean call() {
            return false;
        }
    };

    @Test
    public void StateRemainsUnchanged() {
        IgnoredTriggerBehaviour<State, Trigger> ignored = new IgnoredTriggerBehaviour<>(Trigger.X, RETURN_TRUE);
        assertFalse(ignored.resultsInTransitionFrom(State.B, new Object[0], new OutVar<State>()));
    }

    @Test
    public void ExposesCorrectUnderlyingTrigger() {
        IgnoredTriggerBehaviour<State, Trigger> ignored = new IgnoredTriggerBehaviour<>(Trigger.X, RETURN_TRUE);
        assertEquals(Trigger.X, ignored.getTrigger());
    }

    @Test
    public void WhenGuardConditionFalse_IsGuardConditionMetIsFalse() {
        IgnoredTriggerBehaviour<State, Trigger> ignored = new IgnoredTriggerBehaviour<>(Trigger.X, RETURN_FALSE);
        assertFalse(ignored.isGuardConditionMet());
    }

    @Test
    public void WhenGuardConditionTrue_IsGuardConditionMetIsTrue() {
        IgnoredTriggerBehaviour<State, Trigger> ignored = new IgnoredTriggerBehaviour<>(Trigger.X, RETURN_TRUE);
        assertTrue(ignored.isGuardConditionMet());
    }
}
