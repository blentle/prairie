package top.blentle.prairie.core.handler;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/11/23 0023
 * @description :
 * @since : 1.0
 */
public interface HandlerInterceptor {

    boolean preHandle(Object handler) throws Exception;

    void postHandle(Object handler) throws Exception;

    void afterCompletion(Object handler, Exception ex) throws Exception;
}
