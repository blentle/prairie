package top.blentle.prairie.core.loadbalance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/1/23 11:25
 * @mail: blentle.huan.ren@gmail.com
 * @description:
 * @since: 1.0
 */
public class Invocation {
    //target
    private Object target;
    //which method will be delegated
    private Method method;
    //method args
    private Object[] args;

    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object getTarget() {
        return target;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArgs() {
        return args;
    }

    /**
     *
     * @return instance
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * if no action before or after this action ,pass directly
     */
    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, args);
    }
}
