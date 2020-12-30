package fsm;

/**
 * @author zhangzhaolin
 */
@FunctionalInterface
public interface Action<S> {

    void doAction(S newState, Object... params);
}
