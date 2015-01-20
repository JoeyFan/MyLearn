package thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by admin on 14-9-28.
 */
public class TimeTask {
    public static void main(String[] args){
        System.out.println("task begin");
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
              System.out.println("this Time is"+new Date().getSeconds());
            }
        },1000,3000);
    }



}