package thread;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by admin on 14-10-2.
 */
public class ThreadPool {
    public static void main(String[] args){
        //两种线程池，1个是固定大小的fixedThredd 另一个是缓存线程池，可以根据实际任务自动增加减少数量
        ExecutorService threadPool= Executors.newCachedThreadPool();//Executors.newFixedThreadPool(3);
        for(int i=0;i<5;i++){
            final int count=i;
            threadPool.execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            for(int j=0;j<10;j++){
                                try {
                                    Thread.sleep(50);
                                    System.out.println("loop of"+j+" index of"+count);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }
            );
        }
       // threadPool.shutdown();
//        threadPool.shutdownNow();
        System.out.println("shutdown");
//线程池定时器相关
        System.out.println("线程池定时器相关");
//Executors.newScheduledThreadPool(3).schedule(new Runnable() {
//    @Override
//    public void run() {
//        System.out.println("selude@!!!");
//    }
//},10, TimeUnit.SECONDS);
//SECONDS.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
//    @Override
//    public void run() {
//        System.out.println("loop run "+new Date().getSeconds());
//    }
//},3,3,TimeUnit.SECONDS);
        System.out.println("单线程线程池+futre与callAble");
        ExecutorService singleServer=Executors.newSingleThreadExecutor();
        Future<String> future=singleServer.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "返回值是 线程并发";
            }
        });
        try {
            System.out.println(new Date().getSeconds());

            if(future.isDone()){
                System.out.println("-------"+future.get());
            }else
                System.out.println("noe Funture!");
            System.out.println(new Date().getSeconds());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("集群任务");
        //集群任务
        ExecutorService threadPollMuiti=Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService=new ExecutorCompletionService<Integer>(threadPollMuiti);
        for(int i=1;i<=10;i++){
            final int seq=i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return seq;
                }
        });}
        for(int i=0;i<10;i++){
            try {
                System.out.println("index is"+completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


}
