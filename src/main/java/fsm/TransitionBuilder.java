package fsm;

/**
 * @author zhangzhaolin
 */
public interface TransitionBuilder<S, E> {

    TransitionBuilder<S, E> from(S source);

    TransitionBuilder<S, E> to(S target);

    TransitionBuilder<S, E> onEvent(E event);

    TransitionBuilder<S, E> doAction(Action<S> action);

    StateMachineBuilder<S, E> and();

    Transition<S, E> buildTransition();
}
