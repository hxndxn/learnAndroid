package LeetCode;

public class LeetCode978 {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        if(n<2) return n;
        int[] lastUp = new int[n];
        int[] lastDown = new int[n];
        lastUp[0] = 1;
        lastDown[0] = 1;
        for (int i = 1; i < n; i++) {
            if(A[i]>A[i-1]){
                lastDown[i] = lastUp[i-1]+1;
                lastUp[i] = 1;
            }
            if(A[i]<A[i-1]){
                lastUp[i] = lastDown[i-1]+1;
                lastDown[i] = 1;
            }
            if(A[i]==A[i-1]){
                lastUp[i] = 1;
                lastDown[i] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,lastUp[i]);
            res = Math.max(res,lastDown[i]);
        }
        return res;
    }
}
