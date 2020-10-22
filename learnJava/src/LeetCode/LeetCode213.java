package LeetCode;

import java.util.Arrays;

public class LeetCode213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int dp0 = 0;
        int dp1 = 0;
        int ans1,ans2;
        for (int i = 0; i < n-1; i++) {
            ans1 = Math.max(dp0+nums[i],dp1);
            dp0 = dp1;
            dp1 = ans1;
        }
        ans1 = dp1;
        dp0 = 0;
        dp1 = 0;
        for (int i = 1; i < n; i++) {
            ans2 = Math.max(dp0+nums[i],dp1);
            dp0 = dp1;
            dp1 = ans2;
        }
        return Math.max(ans1,dp1);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode213().rob(new int[]{2,7,9,3,1}));
    }
}
