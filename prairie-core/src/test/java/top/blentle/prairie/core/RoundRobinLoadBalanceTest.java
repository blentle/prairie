package top.blentle.prairie.core;

import java.beans.Introspector;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/1/23 15:55
 * @mail: blentle.huan.ren@gmail.com
 * @description: test name
 * @since: 1.0
 */
public class RoundRobinLoadBalanceTest {
    public static void main(String[] args) {
        String a = Introspector.decapitalize("RoundRobinLoadBalanceTest");
        System.err.println(a);
    }
}
