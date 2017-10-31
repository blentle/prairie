package top.blentle.prairie.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/31 0031
 * @description :
 * @since : 1.0
 */
public class ZookeeperClient implements Watcher {

    private ZooKeeper zk;

    private static final int TIMEOUT = 2000;

    private CountDownLatch countDown;

    public ZookeeperClient(String host, int port) throws IOException, InterruptedException {
        this.zk = new ZooKeeper(host + ":" + port, TIMEOUT, this);
        this.countDown = new CountDownLatch(1);
        this.countDown.await();
        System.err.println("connet server ok ");
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getState().equals(Event.KeeperState.SyncConnected)) {
            System.err.println("client received event invoke...");
            this.countDown.countDown();
        }
    }

    public String createNode(String path, byte[] data) throws KeeperException, InterruptedException {
        return zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public List<String> getChildren(String path) throws KeeperException, InterruptedException {
        return zk.getChildren(path, false);
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZookeeperClient client = new ZookeeperClient("127.0.0.1", 2181);
        String create = client.createNode("/test02", new String("walegequ").getBytes());
        List<String> list = client.getChildren("/");
        System.err.println("........");
    }
}
