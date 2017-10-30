package top.blentle.prairie.core.event.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.blentle.prairie.core.event.Event;
import top.blentle.prairie.core.event.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2016/10/27 0027
 * @description :
 * @since : 1.0
 */
public class DefaultEventBus implements EventBus {

    private static final Logger logger = LoggerFactory.getLogger(DefaultEventBus.class);

    private static final EventListenerComparator LISTENER_COMPARATOR = new EventListenerComparator();

    @Override
    public void publishEvent(Event event) {
        if (event == null) {
            logger.info("Received null event for publishing.  Ignoring and returning.");
            return;
        }

    }

    @Override
    public void register(Object subscriber) {

    }

    @Override
    public void unregister(Object subscriber) {

    }

    private class Subscription {

        private List<EventListener> listeners;

        public Subscription(Set<EventListener> listeners) {
            List<EventListener> sortedListeners = new ArrayList<EventListener>(listeners);
            Collections.sort(sortedListeners, LISTENER_COMPARATOR);
            this.listeners = sortedListeners;
        }


    }
}
