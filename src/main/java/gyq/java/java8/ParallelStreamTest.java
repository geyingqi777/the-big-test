package gyq.java.java8;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by geyingqi on 2019-03-29 11:12.
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        List<TestUser> testUserLinkedList = Lists.newLinkedList();
        List<TestUser> testUserArrayList = Lists.newArrayList();
        List<String> nameList = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            nameList.add(String.valueOf(i));
        }
        // 测试一下并行的stream是否会造成线程安全问题
        nameList.parallelStream().forEach(s -> {
            TestUser testUser = new TestUser();
            testUser.setName(s);
            testUser.setUserId(Long.valueOf(s));
            /**
             * 这里可能会出现这个异常
             *
             * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
             * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
             * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
             * 	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
             * 	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
             * 	at java.util.concurrent.ForkJoinTask.getThrowableException(ForkJoinTask.java:598)
             * 	at java.util.concurrent.ForkJoinTask.reportException(ForkJoinTask.java:677)
             * 	at java.util.concurrent.ForkJoinTask.invoke(ForkJoinTask.java:735)
             * 	at java.util.stream.ForEachOps$ForEachOp.evaluateParallel(ForEachOps.java:160)
             * 	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateParallel(ForEachOps.java:174)
             * 	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:233)
             * 	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:418)
             * 	at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:583)
             * 	at gyq.java.java8.ParallelStreamTest.main(ParallelStreamTest.java:20)
             * Caused by: java.lang.ArrayIndexOutOfBoundsException: 33
             * 	at java.util.ArrayList.add(ArrayList.java:463)
             * 	at gyq.java.java8.ParallelStreamTest.lambda$main$0(ParallelStreamTest.java:24)
             * 	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
             * 	at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1382)
             * 	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:481)
             * 	at java.util.stream.ForEachOps$ForEachTask.compute(ForEachOps.java:291)
             * 	at java.util.concurrent.CountedCompleter.exec(CountedCompleter.java:731)
             * 	at java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:289)
             * 	at java.util.concurrent.ForkJoinPool$WorkQueue.execLocalTasks(ForkJoinPool.java:1040)
             * 	at java.util.concurrent.ForkJoinPool$WorkQueue.runTask(ForkJoinPool.java:1058)
             * 	at java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1692)
             * 	at java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:157)
             */
            testUserArrayList.add(testUser);
            testUserLinkedList.add(testUser);
        });

        try {
            // TODO: 2019-03-29 经过测试,发现ArrayList的size还是会是100,但是有些元素会变成null,并且list的元素顺序,完全被打乱了,不按照1-100的顺序了 
            System.out.println("arraylist的size:" + testUserArrayList.size());
            for (TestUser testUser : testUserArrayList) {
                // System.out.println(JSON.toJSONString(testUser));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("arraylist异常");
        }

        try {
            // TODO: 2019-03-29 经过测试,发现linkedlist的size会小于100,并且在遍历到时候,会在内部的next方法抛出npe异常,并且list的元素顺序,完全被打乱了,不按照1-100的顺序了
            System.out.println("linkedlist的size:" + testUserLinkedList.size());
            /**
             * 可能出现这个异常
             *
             * java.lang.NullPointerException
             * 	at java.util.LinkedList$ListItr.next(LinkedList.java:893)
             */
            for (TestUser testUser : testUserLinkedList) {
                System.out.println(JSON.toJSONString(testUser));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("linkedlist异常");
        }

    }
}
