package leet101_200;

import java.util.HashSet;

public class leet160 {
    //获取两链表相交点
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 存储在哈希表中 时空复杂度较高
        HashSet<ListNode> hastset = new HashSet<>();
        ListNode a = headA;
        ListNode b = headB;
        while(a!= null){
            hastset.add(a);
            a = a.next;
        }
        while (b!=null){
            if (hastset.contains(b))return b;
            b = b.next;
        }
        return null;
    }

    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        // A + B = B + A
        ListNode a = headA;
        ListNode b = headB;
        ListNode ans = null;
        while (!a.equals(b)){
            if (a == null && b == null)break;
            if (a == null)a = headB;
            else a = a.next;
            if (b == null)b = headA;
            else b = b.next;
        }
        ans = a;
        return ans;
    }

    public ListNode getIntersectionNode_2_plus(ListNode headA, ListNode headB) {
        // A + B = B + A
        if(headA == null && headB == null)return null;
        ListNode a = headA,b = headB;
        while (a != b){
            a = a == null?headB:a.next;
            b = b == null?headA:b.next;
        }
        return a;
    }

}
