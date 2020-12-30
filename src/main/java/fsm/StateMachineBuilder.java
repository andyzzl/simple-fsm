package fsm;

/**
 * @author zhangzhaolin
 */
public interface StateMachineBuilder<S, E> {

    TransitionBuilder<S, E> addTransition();

    StateMachine<S, E> build();
}
