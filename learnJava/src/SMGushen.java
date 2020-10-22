import java.util.ArrayList;
import java.util.Scanner;

public class SMGushen {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<>();
        while (s.hasNextInt()){
            input.add(s.nextInt());
        }
        int n_max=input.get(0);
        for(Integer i:input){
            n_max=Math.max(n_max,i);
        }
        int[]output=new int[n_max];
        boolean up=true;
        int last = 1;
        int temp =0;
        output[0]=1;
        for(int i=1;i<n_max;i++){
            if(up){
                output[i]=output[i-1]+1;
                temp++;
                if(temp==last){
                    temp=0;
                    last++;
                    up=false;
                }
            }
            else{
                output[i]=output[i-1]-1;
                up = true;
            }
        }
        for (int i = 0; i < input.size(); i++) {
            System.out.println(output[input.get(i)-1]);
        }
    }
}
