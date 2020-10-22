package LeetCode;

import java.util.Arrays;

public class LeetCode455 {
    static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int index=g.length-1;
            int count=0;
            for(int i=s.length-1;i>-1;i--){
                for(int j=index;j>-1;j--){
                    if(s[i]>=g[j]){
                        count++;
                        index=j-1;
                        break;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[]g={1,2,3};
        int[]s={1,1};
        new Solution().findContentChildren(g,s);
    }
}
