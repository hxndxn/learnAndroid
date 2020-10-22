
public class Test {
    public static void main(String[] args) throws  InterruptedException {
        System.out.println("main finished");
        for(int i = 0;i<3;i++){
            new HelloThread(i).start();
        }
    }
}
