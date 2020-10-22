package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> reached = new HashSet<>();
        while(head!=null){
            if(reached.add(head)){
                head = head.next;
            }
            else{
                return head;
            }
        }
        return null;
    }
}
