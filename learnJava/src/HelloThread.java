
import java.lang.Thread;


public class HelloThread extends Thread{
    private  static volatile Integer i =0;
    private final int MOD;
    public HelloThread(int mod){
        this.MOD = mod;
    }
    @Override
    public void run() {

        /*while(true){
            synchronized (HelloThread.class) {  //错误：synchronized (i), i++时 i的引用改变
                if (i > 99) {
                    break;
                }
                if (i % 3 == MOD) {
                    System.out.println(i++);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }*/


    }
}
