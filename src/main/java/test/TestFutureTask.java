package test;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFutureTask {

    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> list = new ArrayList<>();

        for (int i = 0; i<20; i++){
            final Integer num = RandomUtils.nextInt();
            Callable<Integer> callable = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return doSomething(num);
                }
            };
            list.add(executorService.submit(callable));
        }

        try {
            for (Future<Integer> future : list){
                Integer result = future.get();
                System.out.println(result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
    }


    public static Integer doSomething(Integer num){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return num;
    }

}
