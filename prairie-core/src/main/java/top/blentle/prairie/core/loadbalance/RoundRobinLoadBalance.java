package top.blentle.prairie.core.loadbalance;

import top.blentle.prairie.core.exceptions.PrairieException;

import java.net.URL;
import java.util.List;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/1/23 11:34
 * @mail: blentle.huan.ren@gmail.com
 * @description: for each all of url
 * @since: 1.0
 */
public class RoundRobinLoadBalance extends AbstractLoadBalance<RoundRobinLoadBalance> {

    public Invoker get(List<Invoker> invokerList, URL url, Invocation invocation) throws PrairieException {
        //........
        return null;
    }
}
