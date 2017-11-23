package top.blentle.prairie.core.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.blentle.prairie.core.util.CollectionUtil;
import top.blentle.prairie.core.util.ObjectUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2016/10/23 0023
 * @description : service execution chain,
 * include  service and filter
 * @since : 1.0
 */
public class HandlerExecutionChain {

    private static final Logger logger = LoggerFactory.getLogger(HandlerExecutionChain.class);
    //service handler
    private Object handler;

    private HandlerInterceptor[] interceptors;

    private List<HandlerInterceptor> interceptorList;

    private int interceptorIndex = -1;


    /**
     * Create a new HandlerExecutionChain.
     * @param handler the handler object to execute
     */
    public HandlerExecutionChain(Object handler) {
        this(handler, (HandlerInterceptor[]) null);
    }

    /**
     * Create a new HandlerExecutionChain.
     * @param handler the handler object to execute
     * @param interceptors the array of interceptors to apply
     * (in the given order) before the handler itself executes
     */
    public HandlerExecutionChain(Object handler, HandlerInterceptor... interceptors) {
        if (handler instanceof HandlerExecutionChain) {
            HandlerExecutionChain originalChain = (HandlerExecutionChain) handler;
            this.handler = originalChain.getHandler();
            this.interceptorList = new ArrayList<HandlerInterceptor>();
            CollectionUtil.mergeArrayIntoCollection(originalChain.getInterceptors(), this.interceptorList);
            CollectionUtil.mergeArrayIntoCollection(interceptors, this.interceptorList);
        }
        else {
            this.handler = handler;
            this.interceptors = interceptors;
        }
    }

    /**
     * Return the handler object to execute.
     * @return the handler object
     */
    public Object getHandler() {
        return this.handler;
    }

    public void addInterceptor(HandlerInterceptor interceptor) {
        initInterceptorList().add(interceptor);
    }

    public void addInterceptors(HandlerInterceptor... interceptors) {
        if (!ObjectUtil.isEmpty(interceptors)) {
            initInterceptorList().addAll(Arrays.asList(interceptors));
        }
    }

    /**
     * Return the array of interceptors to apply (in the given order).
     * @return the array of HandlerInterceptors instances (may be {@code null})
     */
    public HandlerInterceptor[] getInterceptors() {
        if (this.interceptors == null && this.interceptorList != null) {
            this.interceptors = this.interceptorList.toArray(new HandlerInterceptor[this.interceptorList.size()]);
        }
        return this.interceptors;
    }


    private List<HandlerInterceptor> initInterceptorList() {
        if (this.interceptorList == null) {
            this.interceptorList = new ArrayList<HandlerInterceptor>();
            if (this.interceptors != null) {
                // An interceptor array specified through the constructor
                this.interceptorList.addAll(Arrays.asList(this.interceptors));
            }
        }
        this.interceptors = null;
        return this.interceptorList;
    }
}
