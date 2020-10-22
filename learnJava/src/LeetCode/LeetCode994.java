package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCode994 {
    int[] dr = new int[]{-1,0,1,0};
    int[] dc = new int[]{0,-1,0,1};
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        if(rows==0) return 0;
        int columns = grid[0].length;
        if(columns==0) return 0;
        int fresh = 0;
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> minutes = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j]==2){
                    int index = i*columns+j;
                    minutes.put(index,0);
                    queue.offer(index);
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            int now_row = now/columns;
            int now_column = now%columns;
            for(int i =0;i<4;i++){
                int now1_c = now_column+dc[i];
                int now1_r = now_row+dr[i];
                if(now1_c>-1&&now1_c<columns&&now1_r>-1&&now1_r<rows&&grid[now1_r][now1_c]==1){
                    grid[now1_r][now1_c]=2;
                    fresh--;
                    ans = minutes.get(now)+1;
                    minutes.put(now1_r*columns+now1_c,ans);
                    queue.offer(now1_r*columns+now1_c);
                }
            }
        }
        return fresh>0?-1:ans;
    }

    public static void main(String[] args) {
        int [][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new LeetCode994().orangesRotting(grid));
    }
}
