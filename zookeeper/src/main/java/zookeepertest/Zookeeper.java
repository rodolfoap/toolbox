package zookeepertest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

// Based on https://stackoverflow.com/a/33603040/9911256
public class Zookeeper {

	private ZooKeeper zookeeper;
	private CountDownLatch connSignal = new CountDownLatch(0);
	private static String PREFIX = "/myroot/mysub";

	public Zookeeper(String host) throws Exception {
		zookeeper = new ZooKeeper(host, 3000, new Watcher() {
			public void process(WatchedEvent event) {
				System.out.println("WatchedEvent: " + event.getPath() + "::" + event.toString());
				if (event.getState() == KeeperState.SyncConnected) {
					connSignal.countDown();
				}
			}
		});
		connSignal.await();
		createNode("", "None");

	}

	public void createNode(String relPath, String strValue) throws Exception {
		String path = PREFIX + relPath;
		String currentPath = "";
		List<String> segmentList = Arrays.asList(path.split("/"));
		for (int counter = 1; counter < segmentList.size(); counter++) {
			currentPath += "/" + segmentList.get(counter);
			if (zookeeper.exists(currentPath, true) == null) {
				zookeeper.create(currentPath, strValue.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
		}
	}

	private String getNode(String relPath) throws Exception {
		byte[] data = zookeeper.getData(PREFIX + relPath, true, zookeeper.exists(PREFIX + relPath, true));
		return new String(data);
	}

	private List<String> getChildren(String relPath) throws Exception {
		return zookeeper.getChildren(PREFIX + relPath, true);
	}

	public void updateNode(String relPath, String strValue) throws Exception {
		zookeeper.setData(PREFIX + relPath, strValue.getBytes(), zookeeper.exists(PREFIX + relPath, true).getVersion());
	}

	public void deleteNode(String relPath) throws Exception {
		zookeeper.delete(PREFIX + relPath, zookeeper.exists(PREFIX + relPath, true).getVersion());
	}

	public void close() throws InterruptedException {
		zookeeper.close();
	}

	public static void main(String args[]) throws Exception {
		Zookeeper zk = new Zookeeper("192.168.1.17");
		System.out.println("List of nodes:");
		System.out.println("* " + zk.getChildren(""));

		zk.createNode("/UUID0000", "None");
		System.out.println("getNode(): " + zk.getNode("/UUID0000"));

		zk.createNode("/UUID0001", "None");
		System.out.println("getChildren(): " + zk.getChildren(""));

		zk.updateNode("/UUID0000", "UPDATED");
		System.out.println("getNode(): " + zk.getNode("/UUID0000"));

		zk.deleteNode("/UUID0000");
		System.out.println("getChildren(): " + zk.getChildren(""));

		zk.close();
	}

}