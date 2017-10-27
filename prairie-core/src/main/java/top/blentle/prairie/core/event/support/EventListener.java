package top.blentle.prairie.core.event.support;

import top.blentle.prairie.core.event.Event;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/27 0027
 * @description :
 * @since : 1.0
 */
public interface EventListener {

    void onEvent(Event event);

    boolean accept(Event event);
}
