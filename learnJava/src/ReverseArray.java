import java.util.Scanner;

//https://exercise.acmcoder.com/online/online_judge_ques?ques_id=1656&konwledgeId=134
public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        int l = -1, r=-1;
        for (int i = 0; i < n - 1; i++) {
            if (l == -1) {
                if (array[i] > array[i + 1])
                    l = i;
            }
            else{
                if(array[i]<array[i+1]){
                    r=i;
                    break;
                }
            }
        }
        if(l==-1){
            System.out.println("no");
            return;
        }
        if(r==-1){
            r=n-1;
        }
        for (int i = 0; i <(r-l+1)/2 ; i++) {
            int temp = array[l+i];
            array[l+i]=array[r-i];
            array[r-i]=temp;
        }
        for(int i=0;i<n-1;i++){
            if(array[i]>array[i+1]){
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}

