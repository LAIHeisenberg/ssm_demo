package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {



        test2(500);
        test1(500);

    }


    public static void test1(int maxCount) throws InterruptedException {

        long begin = System.currentTimeMillis();
        for (int i=100; i<maxCount; i++){
            String oid = i+"";
            String mailNo = i*2+"";
            String courier = i*3+"";
            System.out.println(oid + " "+ mailNo +" "+courier);
            Thread.sleep(400);
        }
        long end = System.currentTimeMillis();

        System.out.println("======================== 串行执行时间: "+(end - begin) / 1000);

    }

    public static void test2(int maxCount) throws ExecutionException, InterruptedException {

        long begin = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        Future<String> future;
        List<Future<String>> futures = new ArrayList<Future<String>>();
        for(int i = 100; i<maxCount; i++){
            final String oid = i+"";
            final String mailNo = i*2+"";
            final String courier = i*3+"";
            Callable callable = new Callable<String>(){
                @Override
                public String call() throws Exception {
                    Thread.sleep(400);
                    return oid + " "+ mailNo +" "+courier;
                }
            };

            futures.add(executorService.submit(callable));
        }
        executorService.shutdown();
        for (Future<String> f : futures){
            String result = f.get();
            System.out.println(result);
        }

        long end = System.currentTimeMillis();
        System.out.println("======================== 多线程执行时间: "+(end - begin) / 1000);
    }


}
