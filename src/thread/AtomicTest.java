package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 14-10-2.
 */
public class AtomicTest {
  static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        System.out.println(count.get());
       System.out.println(count.incrementAndGet());
System.out.println(count.decrementAndGet());
    }
    class Inner{

    }

}
