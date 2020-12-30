package fsm;

/**
 * @author zhangzhaolin
 */
public interface StateMachine<S, E> {

    void addTransition(Transition<S, E> transition);

    S sendEvent(S currentState, E event, Object... params);
}
