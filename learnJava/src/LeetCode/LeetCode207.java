package LeetCode;

import java.util.*;

public class LeetCode207 {
    static class Graph{
        Map<Integer, List<Integer>> map = new HashMap<>();
        Graph(int[][] vectors){
            for(int i=0;i<vectors.length;i++){
                if (map.get(vectors[i][0]) == null) {
                    map.put(vectors[i][0],new ArrayList<Integer>());
                }
                map.get(vectors[i][0]).add(vectors[i][1]);
            }

        }
        boolean hasCircuit(){
            Set<Integer>nodeSet = new HashSet<>(map.keySet());
            for(List<Integer> list:map.values()){
                for(Integer i : list){
                    nodeSet.add(i);
                }
            }
            Map<Integer,Integer> reached = new HashMap<>();
            for(Integer i :nodeSet){
                reached.put(i,0);
            }
            for(Integer i:nodeSet){
                if(hasCircuit(i,reached))
                    return true;
            }
            return false;
        }
        boolean hasCircuit(int startNode, Map<Integer,Integer>reached){
            reached.put(startNode,1);
            List<Integer> endNodes = map.get(startNode);
            if (endNodes == null) {
                reached.put(startNode,2);
                return  false;
            }
            for(Integer i:endNodes){
                if(reached.get(i)==1){
                    return true;
                }
                if(reached.get(i)==2)
                    continue;
                reached.put(i,1);
                if(hasCircuit(i,reached))
                    return true;
            }
            reached.put(startNode,2);
            return false;
        }


    }
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Graph graph=new Graph(prerequisites);
            return !graph.hasCircuit();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2,new int[][]{{1,0},{2,0}}));
    }
}
