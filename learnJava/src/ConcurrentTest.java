import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentTest {
    static volatile int count;
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static class PrintThread extends Thread{
        private int mod;
        PrintThread(int a){
            mod = a;
            this.setName("Thread "+mod);
        }
        @Override
        public void run() {
            while(count<=100) {
                lock.lock();
                try {
                    if (count % 3 == mod) {
                        System.out.println(Thread.currentThread().getName()+": " + count);
                        count++;
                    }
                    condition.signalAll();
                    condition.await();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
            }
            System.out.println(this.getName()+"打印完了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<3;i++){
            new PrintThread(i).start();
        }
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        while(count<=100){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getPriority());
        lock.lock();
        condition.signalAll();
        lock.unlock();
    }
}
