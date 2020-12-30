package fsm.impl;

import fsm.*;

/**
 * @author zhangzhaolin
 */
public class TransitionBuilderImpl<S, E> implements TransitionBuilder<S, E> {

    private final StateMachineBuilder<S, E> parentBuilder;

    private final Transition<S, E> transition;

    private TransitionBuilderImpl(StateMachineBuilder<S, E> parentBuilder) {
        this.parentBuilder = parentBuilder;
        transition = new Transition<>();
    }

    public static<S, E> TransitionBuilderImpl<S, E> builder(StateMachineBuilder<S, E> parentBuilder) {
        return new TransitionBuilderImpl<>(parentBuilder);
    }

    @Override
    public TransitionBuilder<S, E> from(S source) {
        transition.setSource(source);
        return this;
    }

    @Override
    public TransitionBuilder<S, E> to(S target) {
        transition.setTarget(target);
        return this;
    }

    @Override
    public TransitionBuilder<S, E> onEvent(E event) {
        transition.setEvent(event);
        return this;
    }

    @Override
    public TransitionBuilder<S, E> doAction(Action<S> action) {
        transition.setAction(action);
        return this;
    }

    @Override
    public StateMachineBuilder<S, E> and() {
        return parentBuilder;
    }

    @Override
    public Transition<S, E> buildTransition() {
        if (transition.getSource() == null || transition.getTarget() == null ||
                transition.getEvent() == null || transition.getAction() == null) {
            throw new StateMachineBuildException("Some field of transition is null");
        }
        return transition;
    }
}
