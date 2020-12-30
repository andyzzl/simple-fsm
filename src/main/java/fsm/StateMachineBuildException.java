package fsm;

/**
 * @author zhangzhaolin
 */
public class StateMachineBuildException extends RuntimeException {

    public StateMachineBuildException(String message) {
        super(message);
    }

    public StateMachineBuildException(String message, Exception cause) {
        super(message, cause);
    }
}
