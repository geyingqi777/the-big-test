package gyq.java.concurrent.test;

/**
 * 测试线程的interrupt的特性和一些方法的逻辑
 * 问题: 最终打印出的字符串是?
 */
public class ThreadInterrupt implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
        System.out.println("Final");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadInterrupt());
        thread.start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            thread.interrupt();
            System.out.println("interrupt");
        }).start();
        thread.join();
        System.out.println("exit");
    }
}