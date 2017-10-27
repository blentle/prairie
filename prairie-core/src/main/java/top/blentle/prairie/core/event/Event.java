package top.blentle.prairie.core.event;

import java.util.EventObject;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2016/10/27 0027
 * @description :
 * @since : 1.0
 */
public abstract class Event extends EventObject {

    private final long timestamp;

    public Event(Object source) {
        super(source);
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }
}
