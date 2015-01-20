package thread;

import java.util.concurrent.locks.*;

/**
 * Created by admin on 14-10-4.
 */
public class LockAndSynchronizedTest {
    public static void main(String[] args) {
        final Output output = new Output();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //output.printOne("luck");
                    output.printLock("AAAA");
                }
            }
        }).start();

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //output.printOne("good");
                    output.printLock("1111");
                }
            }
        }.start();
    }

}

class Output {

    public void printOne(String str) {
        int len = str.length();
        synchronized (Output.class) {//锁定同一对象
            for (int i = 0; i < len; i++) {
                System.out.print(str.charAt(i));
            }
        }
        // for(char c:str.toCharArray()){
        //   System.out.print(c);
        //}
        System.out.println("");
    }

    public void printTwo(String str) {
        int len = str.length();
        synchronized (Output.class) {//锁定同一对象
            for (int i = 0; i < len; i++) {
                System.out.print(str.charAt(i));
            }
        }
        // for(char c:str.toCharArray()){
        //   System.out.print(c);
        //}
        System.out.println("");
    }
    Lock lock = new ReentrantLock();
    ReadWriteLock readWriteLock=new ReentrantReadWriteLock();//读写锁000000000000000000000000000000

    public void printLock(String str) {
        lock.lock();
//        readWriteLock.readLock().lock();
//        readWriteLock.writeLock().lock();
//        readWriteLock.readLock().unlock();
//        readWriteLock.writeLock().unlock();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            System.out.print(str.charAt(i));
        }
        System.out.println("");
        lock.unlock();
    }
}