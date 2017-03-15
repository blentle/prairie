package top.blentle.prairie.core.loadbalance;

import top.blentle.prairie.core.exceptions.PrairieException;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

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
        //todo:
        return null;
    }

    private static class VirtualNodeHash {
        //load from config
        private static String[] serverList = {"192.168.10.1:11001","192.168.10.2:11001","192.168.10.3:11001","192.168.10.4:11001","192.168.10.5:11001","192.168.10.6:11001"};

        //real node :use linked list for add or delete frequently .
        private static List<String> realNodeList = new LinkedList<String>();

        /**
         * key:virtual node hash value
         * value: virtual node
         */
        private static SortedMap<Integer,String> virtualNodeList = new TreeMap<Integer, String>();

        private static int virtualNodeSize;

        static {
            //add read nodes
            for(String server : serverList) {
                realNodeList.add(server);
            }
            //add virtual node
            for(String realServer : serverList) {
                for(int index = 0 ; index < virtualNodeSize ; index ++) {
                    String nodeName = realServer + "###VirtualNode" + String.valueOf(index);
                    int hash = generateHash(nodeName);
                    virtualNodeList.put(hash,nodeName);
                }
            }

        }
        public VirtualNodeHash(int virtualNodeSize) {
            this.virtualNodeSize = virtualNodeSize;
        }

        private static int generateHash(String node) {
            //todo:validate
            final int r = 16776897;
            int hash = (int)2166136269L;
            for (int i = 0; i < node.length(); i++) {
                hash = (hash ^ node.charAt(i)) * r;
            }
            hash += hash << 13;
            hash ^= hash >> 7;
            hash += hash << 3;
            hash ^= hash >> 17;
            hash += hash << 5;
            if (hash < 0)
                hash = Math.abs(hash);
            return hash;
        }


    }
}
