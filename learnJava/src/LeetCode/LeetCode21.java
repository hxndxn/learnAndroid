package LeetCode;

public class LeetCode21 {
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int i){
            this.val=i;
        }
        ListNode(){}
    }
    public ListNode merge2LinkedList(ListNode a, ListNode b){
        ListNode res = new ListNode(), tail = res, aPtr = a, bPtr=b;
        while(aPtr!=null&&bPtr!=null){
            if(aPtr.val < bPtr.val){
                tail.next = aPtr;
                aPtr = aPtr.next;
            }
            else{
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        if(aPtr==null){
            tail.next = bPtr;
        }
        else{
            tail.next = aPtr;
        }
        return res.next;
    }
}
