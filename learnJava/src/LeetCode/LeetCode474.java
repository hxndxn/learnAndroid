package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode474 {
    static class Solution {
        int count(String str,char c){
            int count=0;
            char[]array= str.toCharArray();
            for(int i=0;i<array.length;i++){
                if(array[i]==c){
                    count++;
                }
            }
            return count;
        }
        public int findMaxForm(String[] strs, int m, int n) {
            int length = strs.length;
            if (length==0) return 0;
            int[][][]dp=new int[strs.length][m+1][n+1];
            for(int i=0;i<strs.length;i++){
                int curr_0=count(strs[i],'0');
                int curr_1=count(strs[i],'1');
                System.out.println(""+curr_0+" "+curr_1);
                for(int j=0;j<m+1;j++){
                    for(int k =0;k<n+1;k++){
                        if(j<curr_0||k<curr_1){
                            if(i==0)
                                dp[i][j][k]=0;
                            else
                                dp[i][j][k]=dp[i-1][j][k];
                        }
                        else {
                            if(i==0){
                                dp[i][j][k]=1;
                            }
                            else
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i-1][j - curr_0][k - curr_1] + 1);
                        }
                    }
                }
            }
            return dp[strs.length-1][m][n];
        }
    }

    public static void main(String[] args) {
        String[] strs={"10","0001","111001","1","0"};
        System.out.println(new Solution().findMaxForm(strs,5,3));
    }
}
