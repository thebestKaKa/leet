package leet1_100;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class leet21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //合并有序链表
        if(l1 == null){return l2;}
        else if(l2 == null){return l1;}
        else if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }
}
