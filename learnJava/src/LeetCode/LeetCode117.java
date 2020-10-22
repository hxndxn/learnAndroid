package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode117 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node prev = null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            prev=null;
            int layer_size = queue.size();
            for (int i = 0; i < layer_size; i++) {
                Node temp = queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
                if(prev!=null){
                    prev.next = temp;
                }
                prev = temp;
            }
        }
        return root;
    }
}
