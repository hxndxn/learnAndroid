package LeetCode;

public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        ListNode extra = head;
        while(head!=null&&head.next!=null){
            extra = extra.next;
            head = head.next.next;
            if(head==extra) return true;
        }
        return false;
    }
}
