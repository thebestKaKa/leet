package leet1_100;

public class leet83 {
    //删除有序链表中重复数据节点
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode  p = head;
        while (p != null){
            while (p.next != null && p.val == p.next.val){
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }


}
