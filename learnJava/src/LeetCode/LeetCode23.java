package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;
//优先队列
public class LeetCode23 {
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int i){
            this.val=i;
        }
        ListNode(){}
    }
    static class ComparableNode implements Comparable<ComparableNode>{
        ListNode mListNode;
        ComparableNode(ListNode listNode){
            mListNode = listNode;
        }
        @Override
        public int compareTo(ComparableNode o) {
            return mListNode.val-o.mListNode.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ComparableNode> queue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null)
            queue.offer(new ComparableNode(lists[i]));
        }
        ListNode res = new ListNode(), tail = res;
        while(!queue.isEmpty()){
            ListNode temp = queue.poll().mListNode;
            tail.next = temp;
            tail = temp;
            if(temp.next!=null){
                queue.offer(new ComparableNode(temp.next));
            }
        }
        return res.next;
    }
}
