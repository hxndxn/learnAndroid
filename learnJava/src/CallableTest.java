import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    private static Integer randomInt(){
        for(int i=0;i<10000;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
        return new Random(114541).nextInt();
    }
    public static void main(String[] args) {
        FutureTask<Integer> ft = new FutureTask<>(CallableTest::randomInt);
        for (int i =0;i<30000;i++){
            System.out.println(Thread.currentThread().getName()+i);
            if(i==1) {
                new Thread(ft, "子线程").start();
            }
        }
        try {
            System.out.println("子线程返回值： "+ft.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 