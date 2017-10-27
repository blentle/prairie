package top.blentle.prairie.core.event.support;

import top.blentle.prairie.core.event.Event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/27 0027
 * @description :
 * @since : 1.0
 */
public class SingleArgumentEventListener implements TypeEventListener {

    private final Object target;

    private final Method method;

    public SingleArgumentEventListener(Object target, Method method) {
        this.target = target;
        this.method = method;
        //check single argument
        getArgumentType(method);
        // check method publish
        assertPublishMethod(method);

    }

    @Override
    public Class<?> getEventType() {
        return getArgumentType(method);
    }

    @Override
    public void onEvent(Event event) {
        Method method = getMethod();
        try {
            method.invoke(target, event);
        } catch (Exception e) {
            throw new IllegalStateException("Unable to invoke event handler method [" + method.getName() + "].", e);
        }
    }

    @Override
    public boolean accept(Event event) {
        return getEventType().isInstance(event);
    }

    public Object getTarget() {
        return target;
    }

    public Method getMethod() {
        return method;
    }

    private void assertPublishMethod(Method method) {
        int modifiers = method.getModifiers();
        if (!Modifier.isPublic(modifiers))
            throw new IllegalArgumentException("Event handler method:[" + method.getName() + "] must be public.");
    }

    private Class<?> getArgumentType(Method method) {
        int parameterCount = method.getParameterCount();
        if (parameterCount != 1)
            throw new IllegalArgumentException("Event handler method:[" + method.getName() + "] must accept a single argument.");
        return method.getParameterTypes()[0];
    }
}
