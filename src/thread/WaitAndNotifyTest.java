package thread;

/**
 * Created by admin on 14-9-30.
 *子线程循环10遍，主线程循环100变。然后子线程循环10遍，主线程循环100遍。依次进行50遍
 */
public class WaitAndNotifyTest {
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
}
class Business{
    private boolean flag=false;//true 住执行，false子执行
    //zi
   public synchronized void sub(int index){
       while(flag){
           try {
               this.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
       for(int i=0;i<10;i++){
           System.out.println("sub index is"+i +"index is"+index);
       }
       flag=true;
       this.notify();
   }
    //main
   public synchronized void main(int index){
       while (!flag){
           try {
               this.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
       for(int i=0;i<100;i++){
           System.out.println("main index is"+i +"index is"+index);
       }
       flag=false;
       this.notify();
   }

}
