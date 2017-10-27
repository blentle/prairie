package top.blentle.prairie.core.event.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.blentle.prairie.core.event.Event;
import top.blentle.prairie.core.event.EventBus;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2016/10/27 0027
 * @description :
 * @since : 1.0
 */
public class DefaultEventBus implements EventBus {

    private static final Logger logger = LoggerFactory.getLogger(DefaultEventBus.class);

    @Override
    public void publishEvent(Event event) {

    }

    @Override
    public void register(Object subscriber) {

    }

    @Override
    public void unregister(Object subscriber) {

    }
}
