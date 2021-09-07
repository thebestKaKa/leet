package leet1_100;

import javax.print.DocFlavor;

public class leet23_mergeKLists {
    //合并k个有序链表
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class MinPQ {
        //优先队列 动态调整数组大小
        private int[] pq;
        private int N = 0;

        public MinPQ(int maxN){
            pq = new int[maxN + 1];
        }

        private void resize(int len){
            int[] pq_new = new int[len + 1];
            for (int i = 1; i <= N; i++) {
                pq_new[i] = pq[i];
            }
            pq = pq_new;
        }

        public void insert(int v){
            if (N + 1 == pq.length) resize(2 * pq.length);
            pq[++N] = v;
            swim(N);
        }

        public int deleteMin(){
            int min = pq[1];
            exch(1, N--);
            //pq[1] = pq[N--];
            if (N == pq.length/4)resize(pq.length/2);
            pq[N + 1] = 0;
            sink(1);
            return min;
        }

        private void swim(int k){
            while (k > 1 && less(k, k/2)){
                exch(k, k/2);
                k = k/2;
            }
        }

        private void sink(int k){
            while (2 * k <= N){//注意考虑最后的节点
                int j = 2 * k;
                if (j < N && less(j + 1, j))j++;
                if (less(k, j))break;
                exch(k, j);
                k = j;
            }
        }

        private void exch(int a, int b){
            int t = pq[a];
            pq[a] = pq[b];
            pq[b] = t;
        }

        private boolean less(int a, int b){
            return pq[a] < pq[b];
        }

        public boolean isEmpty(){
            return N == 0;
        }

        public int size(){
            return N;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)return null;//空
        MinPQ minPQ = new MinPQ(lists.length);
        for (ListNode list : lists) {
            while (list != null){
                minPQ.insert(list.val);
                list = list.next;
            }
        }
        if (minPQ.isEmpty())return null;//多条均为空
        ListNode start = new ListNode();
        start.val = minPQ.deleteMin();
        if (minPQ.isEmpty())return start;
        ListNode listNode = new ListNode();
        start.next = listNode;
        while (true){
            listNode.val = minPQ.deleteMin();
            if (minPQ.isEmpty())break;
            ListNode next = new ListNode();
            listNode.next = next;
            listNode = listNode.next;
        }
        return start;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[1];
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(6);
        listNode7.next = listNode8;

        lists[0] = listNode1;

        ListNode ans = mergeKLists(lists);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
