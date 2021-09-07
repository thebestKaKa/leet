package leet201_300;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class leet_215_findKthLargest {
    //数组中第k个最大元素
    public static class MaxPQ {
        //优先队列 动态调整数组大小
        private int[] pq;
        private int N = 0;

        public MaxPQ(int maxN){
            pq = new int[maxN + 1];
        }

        public MaxPQ(int[] a){
            pq = new int[a.length + 1];
            for (int i : a) {
                insert(i);
            }
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

        public int deleteMax(){
            int max = pq[1];
            exch(1, N--);
            //pq[1] = pq[N--];
            if (N == pq.length/4)resize(pq.length/2);
            pq[N + 1] = 0;
            sink(1);
            return max;
        }

        private void swim(int k){
            while (k > 1 && less(k/2, k)){
                exch(k, k/2);
                k = k/2;
            }
        }

        private void sink(int k){
            while (2 * k <= N){//注意考虑最后的节点
                int j = 2 * k;
                if (j < N && less(j, j + 1))j++;
                if (less(j, k))break;
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

    public static int findKthLargest(int[] nums, int k) {
        MaxPQ pq = new MaxPQ(nums);
        int ans = -1;
        while(k != 0){
            ans = pq.deleteMax();
            k--;
        }
        return ans;
    }

    public static int findKthLargest_2(int[] nums, int k) {
        //堆排序
        int N = nums.length - 1;
        for (int i = nums.length/2 - 1; i >= 0 ; i--) {
            sink(nums, N, i);
        }
        for (int i = N; i >= 0 ; i--) {
            exch(nums, 0, N--);
            sink(nums, N, 0);
            k--;
            if (k == 0)return nums[N + 1];
        }
        return -1;
    }

    public static void sink(int[] nums, int N, int k){
        while (2 * k + 1 <= N){
            int j = 2 * k + 1;
            if (j < N && nums[j] < nums[j + 1]) j++;
            if (nums[k] > nums[j])break;
            exch(nums, k, j);
            k = j;
        }
    }

    public static void exch(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest_2(nums, 4));
    }
}
