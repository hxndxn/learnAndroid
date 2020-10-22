package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode210 {
    // 存储有向图
    List<List<Integer>> edges = new ArrayList<>();;
    // 存储每个节点的入度
    int[] indeg;
    // 存储答案
    int[] result;
    //
    int index=0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indeg = new int[numCourses];
        result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for(int[] info:prerequisites){
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indeg[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            result[index++]=now;
            for(int i:edges.get(now)){
                if(--indeg[i]==0){
                    queue.offer(i);
                }
            }
        }
        if(index!=numCourses){
            return new int[0];
        }
        else{
            return result;
        }
    }

    public static void main(String[] args) {
        int[] result = new LeetCode210().findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}});
        for(int i:result){
            System.out.println(i);
        }
    }
}
