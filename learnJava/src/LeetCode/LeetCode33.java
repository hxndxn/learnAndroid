package LeetCode;

public class LeetCode33 {


    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1, mid;
        while(l<=r){
            mid = (l+r)/2;
            if(target==nums[mid]) return mid;
            if(nums[l]<=nums[mid]){
                if(nums[l]<=target && target<=nums[mid]) r = mid-1;
                else l = mid+1;
            }
            else{
                if(nums[mid]<=target && target<=nums[r]) l = mid+1;
                else r = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int res = new LeetCode33().search(new int[]{5,1,3},5);
        System.out.println(res);
    }
}
