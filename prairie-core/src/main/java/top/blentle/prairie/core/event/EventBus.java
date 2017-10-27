package top.blentle.prairie.core.event;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2016/10/27 0027
 * @description :
 * @since : 1.0
 */
public interface EventBus {

    void publishEvent(Event event);

    void register(Object subscriber);

    void unregister(Object subscriber);
}
