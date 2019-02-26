package gyq.java.concurrent.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 利用future和concurrentHashMap获取一个唯一的connection对象, 在多线程环境下,第一个线程会执行,connectionTask.run()方法, 其余线程由于pool.putIfAbsent方法是线程安全的,所以会得到之前的futureTask对象,并等待得到结果
 */
public class FutureConnectionPool {

	private ConcurrentHashMap<String, FutureTask<Connection>> pool = new ConcurrentHashMap<String, FutureTask<Connection>>();

	public Connection getConnection(String key) throws InterruptedException, ExecutionException {
		FutureTask<Connection> connectionTask = pool.get(key);
		if (connectionTask != null) {
			return connectionTask.get();
		} else {
			Callable<Connection> callable = () -> createConnection();
			FutureTask<Connection> newTask = new FutureTask<>(callable);
			connectionTask = pool.putIfAbsent(key, newTask);
			if (connectionTask == null) {
				connectionTask = newTask;
				connectionTask.run();
			}
			return connectionTask.get();
		}
	}

	public Connection createConnection() {
		return new Connection();
	}

	class Connection {
	}
}