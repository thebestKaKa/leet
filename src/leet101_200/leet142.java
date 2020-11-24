package leet101_200;

import java.util.HashSet;

public class leet142 {
    public ListNode detectCycle(ListNode head) {
        // 使用set存储
        HashSet<ListNode> isVisited = new HashSet<>();
        while(head != null){
            if (isVisited.contains(head))return head;
            isVisited.add(head);
            head = head.next;
        }
        return null;
    }
    public ListNode detectCycle_2(ListNode head) {
        // 不使用额外空间
        // a = c + n * (b + c)
        ListNode fast = head,slow = head;
        ListNode ptr = head;
        while(fast != null){
            if(fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                while (ptr != slow){
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
