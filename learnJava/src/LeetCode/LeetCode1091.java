package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCode1091 {
    int[] dr = new int[]{-1,0,1,0,-1,-1,1,1};
    int[] dc = new int[]{0,-1,0,1,-1,1,-1,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n==0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> length = new HashMap<>();
        if(grid[0][0]==1){
            return -1;
        }
        grid[0][0]=1;
        queue.offer(0);
        length.put(0,1);
        int ans = 1;
        while(!queue.isEmpty()){
            int now = queue.poll();
            int nowr = now/n;
            int nowc = now%n;
            if(nowc==n-1&&nowr==n-1){
                return length.get(now);
            }
            for (int i = 0; i < 8; i++) {
                int now1r = nowr+dr[i];
                int now1c = nowc+dc[i];
                if(now1r>-1&&now1r<n&&now1c>-1&&now1c<n&&grid[now1r][now1c]==0){
                    grid[now1r][now1c]=1;
                    queue.offer(now1r*n+now1c);
                    ans =length.get(now)+1;
                    length.put(now1r*n+now1c,ans);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [][] grid = new int[][]{
                {0,0,1,0},
                {1,0,1,0},
                {1,1,0,1},
                {0,0,0,0}
        };
        int res = new LeetCode1091().shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }
}
/*
* 0 0 1 0
* 1 0 1 0
* 1 1 0 1
* 0 0 0 0*/