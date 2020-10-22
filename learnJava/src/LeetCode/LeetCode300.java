package LeetCode;

public class LeetCode300 {
    static class Solution{
        public int lengthOfLIS(int[] nums) {
            int size = nums.length;
            if(size ==0) return 0;
            int []dp=new int[size];
            dp[0]=1;
            for(int i=0;i<size;i++){
                for(int j=0;j<i;j++){
                    dp[i]=Math.max(dp[i],nums[j]<nums[i]?dp[j]+1:1);
                }
            }
            int res =0;
            for(int i=0;i<size;i++){
                res=Math.max(res,dp[i]);
            }
            return res;
        }
    }
}
