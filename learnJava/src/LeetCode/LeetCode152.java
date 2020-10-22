package LeetCode;

public class LeetCode152 {
    static class Solution {
        public int maxProduct(int[] nums) {
            if(nums.length==0)  return 0;
            int premax=nums[0];
            int premin=nums[0];
            int res =premax;
            for(int i=1;i<nums.length;i++) {
                int max = Math.max(Math.max(premax * nums[i], premin*nums[i]),nums[i]);
                premin= Math.min(Math.min(premax*nums[i],premin*nums[i]),nums[i]);
                premax=max;
                res = Math.max(res,max);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxProduct(new int[]{2,3,-2,4}));
    }
}
