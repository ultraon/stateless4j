package com.github.oxo42.stateless4j;

import com.github.oxo42.stateless4j.transitions.TransitioningTriggerBehaviour;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriggerBehaviourTests {

    @Test
    public void ExposesCorrectUnderlyingTrigger() {
        TransitioningTriggerBehaviour<State, Trigger> transtioning = new TransitioningTriggerBehaviour<>(
                Trigger.X, State.C, IgnoredTriggerBehaviourTests.RETURN_TRUE);

        assertEquals(Trigger.X, transtioning.getTrigger());
    }

    @Test
    public void WhenGuardConditionFalse_IsGuardConditionMetIsFalse() {
        TransitioningTriggerBehaviour<State, Trigger> transtioning = new TransitioningTriggerBehaviour<>(
                Trigger.X, State.C, IgnoredTriggerBehaviourTests.RETURN_FALSE);

        assertFalse(transtioning.isGuardConditionMet());
    }

    @Test
    public void WhenGuardConditionTrue_IsGuardConditionMetIsTrue() {
        TransitioningTriggerBehaviour<State, Trigger> transtioning = new TransitioningTriggerBehaviour<>(
                Trigger.X, State.C, IgnoredTriggerBehaviourTests.RETURN_TRUE);

        assertTrue(transtioning.isGuardConditionMet());
    }
}
