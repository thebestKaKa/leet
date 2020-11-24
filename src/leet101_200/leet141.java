package leet101_200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class leet141 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> isvisited = new HashSet<>();
        while (head != null){
            if (isvisited.contains(head)) return true;
            else {
                isvisited.add(head);
                head = head.next;
            }
        }
        return false;
    }

    public boolean hasCycle_2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            if (fast.next == null)return false;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)return true;
        }
        return false;
    }
}
