package thread;
import java.util.Random;

/**
 * Created by admin on 14-10-1.
 */
public class ThreadLocalTest {
    static ThreadLocal<Integer> data=new ThreadLocal<Integer>();
    //static ThreadLocal<User> user=new ThreadLocal<User>();
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int d = new Random().nextInt();
                    data.set(d);
                    System.out.println(Thread.currentThread().getName() + "----------" + d);
                    User.getUserInstance().setAge(d);
                    User.getUserInstance().setName("name is" + d);
                    new A().get();
                    new B().get();

                }
            }){}.start();
        }
    }

    static class A {
        public void get() {
            System.out.println("data is:"+data.get()+"  Auser:"+Thread.currentThread().getName() + "A username is" + User.getUserInstance().getName() + ",age" + User.getUserInstance().getAge());
        }
    }

    static class B {
        public void get() {
            System.out.println("data is"+data.get()+ "   Buser:"+Thread.currentThread().getName() + "B username is" + User.getUserInstance().getName() + ",age" + User.getUserInstance().getAge());
        }
    }
}

class User {
    private User() {
    }

    ;

    public static User getUserInstance() {
        if (threadUser.get() == null) {
            threadUser.set(new User());
        }
        return threadUser.get();
    }

    private static ThreadLocal<User> threadUser = new ThreadLocal<User>();
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
