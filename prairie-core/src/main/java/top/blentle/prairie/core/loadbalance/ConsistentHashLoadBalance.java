package top.blentle.prairie.core.loadbalance;

import top.blentle.prairie.core.exceptions.PrairieException;

import java.net.URL;
import java.util.List;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/3/7 15:37
 * @mail: blentle.huan.ren@gmail.com
 * @description:
 * @since: 1.0
 */
public class ConsistentHashLoadBalance extends  AbstractLoadBalance<ConsistentHashLoadBalance>{

    public Invoker get(List<Invoker> invokerList, URL url, Invocation invocation) throws PrairieException {
        return null;
    }
}
