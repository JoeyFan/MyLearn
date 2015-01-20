package thread;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //1
        Thread one=new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("one is:"+Thread.currentThread().getName());
                }

            }
        };
        one.start();


       //2这种用得最多
        Thread two=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("two is:"+Thread.currentThread().getName());
                }
            }
        });
        two.start();
        //3
        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("three is:"+Thread.currentThread().getName());
                }
            }
        }.start();
        //理解面向对象编程的概念
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("for ruanable is runing");
            }
        }){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("for is:"+Thread.currentThread().getName());
                }
            }
        }.start();

    }
}
