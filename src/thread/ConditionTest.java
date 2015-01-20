package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 14-9-30.
 *子线程循环10遍，主线程循环100变。然后子线程循环10遍，主线程循环100遍。依次进行50遍
 */
public class ConditionTest {
    final static Business business=new Business();
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<50;i++){
                    business.sub(i);

                };
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<50;i++){
                    business.main(i);
                };
            }
        }).start();
    }


    static class Business{
        private boolean flag=false;//true 主执行，false子执行
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        //zi
        public  void sub(int index){
            lock.lock();
            try{
                while(flag){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int i=0;i<10;i++){
                    System.out.println("sub index is"+i +"index is"+index);
                }
                flag=true;
                //this.notify();
                condition.signal();
            }finally {
                lock.unlock();
            }
        }
        //main
        public  void main(int index){
            lock.lock();
            try{
                while (!flag){
                    try {
                       condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for(int i=0;i<100;i++){
                    System.out.println("main index is"+i +"index is"+index);
                }
                flag=false;
                //this.notify();
                condition.signal();
            }finally {
                lock.unlock();
            }

        }

    }

}
