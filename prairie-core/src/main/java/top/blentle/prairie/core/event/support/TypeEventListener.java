package top.blentle.prairie.core.event.support;


/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/27 0027
 * @description :
 * @since : 1.0
 */
public interface TypeEventListener extends EventListener{
    Class<?> getEventType();
}
