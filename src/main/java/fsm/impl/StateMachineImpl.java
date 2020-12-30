package fsm.impl;

import fsm.Action;
import fsm.StateMachine;
import fsm.Transition;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangzhaolin
 */
public class StateMachineImpl<S, E> implements StateMachine<S, E> {

    // sourceState --event--> targetState, and do action
    private final Map<S, Map<E, Target<S, E>>> transitionMap;

    public StateMachineImpl() {
        this.transitionMap = new HashMap<>();
    }

    @Override
    public void addTransition(Transition<S, E> transition) {
        if (!transitionMap.containsKey(transition.getSource())) {
            transitionMap.put(transition.getSource(), new HashMap<>());
        }
        Map<E, Target<S, E>> eventTargetMap = transitionMap.get(transition.getSource());
        Target<S, E> target = new Target<>();
        target.setState(transition.getTarget());
        target.setAction(transition.getAction());
        eventTargetMap.put(transition.getEvent(), target);
    }

    @Override
    public S sendEvent(S currentState, E event, Object ...params) {
        if (!transitionMap.containsKey(currentState)) {
            return null;
        }
        Map<E, Target<S, E>> eventTargetMap = transitionMap.get(currentState);
        Target<S, E> target = eventTargetMap.getOrDefault(event, Target.noop());
        target.getAction().doAction(target.getState(), params);
        return target.getState();
    }

    @Getter
    @Setter
    private static class Target<S, E> {

        private S state;
        private Action<S> action;

        public static<S, E> Target<S, E> noop() {
            Target<S, E> target = new Target<>();
            target.setAction((newState, event) -> {});
            return target;
        }
    }
}
