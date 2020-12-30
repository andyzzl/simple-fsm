package fsm;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangzhaolin
 */
@Getter
@Setter
public class Transition<S, E> {

    private S source;

    private S target;

    private E event;

    private Action<S> action;
}
