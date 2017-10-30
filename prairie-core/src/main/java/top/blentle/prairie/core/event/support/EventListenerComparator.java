package top.blentle.prairie.core.event.support;

import java.util.Comparator;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/06/30
 * @description :
 * @since : 1.0
 */
public class EventListenerComparator implements Comparator<EventListener> {

    private static final EventClassComparator CLASS_COMPARATOR = new EventClassComparator();

    @Override
    public int compare(EventListener a, EventListener b) {
        if (a == null) {
            if (b == null) {
                return 0;
            } else {
                return -1;
            }
        } else if (b == null) {
            return 1;
        } else if (a == b || a.equals(b)) {
            return 0;
        } else {
            if (a instanceof TypeEventListener) {
                TypeEventListener ta = (TypeEventListener) a;
                if (b instanceof TypeEventListener) {
                    TypeEventListener tb = (TypeEventListener) b;
                    return CLASS_COMPARATOR.compare(ta.getEventType(), tb.getEventType());
                } else {
                    return -1; //TypedEventListeners are 'less than' (higher priority) than non typed
                }
            } else {
                if (b instanceof TypeEventListener) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
