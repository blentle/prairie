package top.blentle.prairie.core.loadbalance;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/1/23 11:23
 * @mail: blentle.huan.ren@gmail.com
 * @description:
 * @since: 1.0
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException;

    Class<?> getType();
}
