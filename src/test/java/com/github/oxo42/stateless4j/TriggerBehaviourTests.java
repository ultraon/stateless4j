package com.github.oxo42.stateless4j;

import org.junit.Assert;
import org.junit.Test;

import com.github.oxo42.stateless4j.transitions.TransitioningTriggerBehaviour;

import static com.github.oxo42.stateless4j.IgnoredTriggerBehaviourTests.toUntypedGuard;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TriggerBehaviourTests {

    @Test
    public void ExposesCorrectUnderlyingTrigger() {
        TransitioningTriggerBehaviour<State, Trigger> transtioning = new TransitioningTriggerBehaviour<>(
                Trigger.X, State.C, toUntypedGuard(IgnoredTriggerBehaviourTests.returnTrue));

        assertEquals(Trigger.X, transtioning.getTrigger());
    }

    @Test
    public void WhenGuardConditionFalse_IsGuardConditionMetIsFalse() {
        TransitioningTriggerBehaviour<State, Trigger> transtioning = new TransitioningTriggerBehaviour<>(
                Trigger.X, State.C, toUntypedGuard(IgnoredTriggerBehaviourTests.returnFalse));

        assertFalse(transtioning.isGuardConditionMet(null));
    }

    @Test
    public void WhenGuardConditionTrue_IsGuardConditionMetIsTrue() {
        TransitioningTriggerBehaviour<State, Trigger> transtioning = new TransitioningTriggerBehaviour<>(
                Trigger.X, State.C, toUntypedGuard(IgnoredTriggerBehaviourTests.returnTrue));

        assertTrue(transtioning.isGuardConditionMet(null));
    }
}
