package fsm.impl;

import fsm.StateMachine;
import fsm.StateMachineBuilder;
import fsm.TransitionBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhaolin
 */
public class StateMachineBuilderImpl<S, E> implements StateMachineBuilder<S, E> {

    private final List<TransitionBuilder<S, E>> transitionBuilders;

    private StateMachineBuilderImpl() {
        transitionBuilders = new ArrayList<>();
    }

    public static<S, E> StateMachineBuilderImpl<S, E> builder() {
        return new StateMachineBuilderImpl<>();
    }

    @Override
    public TransitionBuilder<S, E> addTransition() {
        TransitionBuilder<S, E> transitionBuilder = TransitionBuilderImpl.builder(this);
        transitionBuilders.add(transitionBuilder);
        return transitionBuilder;
    }

    @Override
    public StateMachine<S, E> build() {
        StateMachine<S, E> stateMachine = new StateMachineImpl<>();
        transitionBuilders.forEach(builder -> stateMachine.addTransition(builder.buildTransition()));
        return stateMachine;
    }
}
