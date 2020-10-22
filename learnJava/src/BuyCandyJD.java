import java.util.Scanner;

//https://exercise.acmcoder.com/online/online_judge_ques?ques_id=3812&konwledgeId=41
public class BuyCandyJD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }
        int v = s.nextInt();
        int[][] dp=new int[n+1][v+1];


        for(int i=1;i<n+1;i++){
            int currv = s.nextInt();
            int currpi = s.nextInt();
            for(int j=0;j<v+1;j++){
                if(i==1){
                    dp[i][j]=currpi;
                }else
                dp[i][j] = Math.max(dp[i-1][j],j>=currv?dp[i-1][j-currv]+currpi:0);
            }
        }
        System.out.println(dp[n-1][v-1]);
    }
}

