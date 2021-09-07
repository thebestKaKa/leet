package algorithms;

public class MaxPQ<Key extends Comparable<Key>> {
    //优先队列
    private Key[] pq;
    private int N;

    public MaxPQ(int maxn){
        //0不用
        pq = (Key[]) new Comparable[maxn + 1];
        N = 0;
    }

    public MaxPQ(Key[] a){
        pq = (Key[]) new Comparable[a.length + 1];
        N = a.length;
        for (int i = 1; i < pq.length; i++) {
            pq[i] = a[i - 1];
            swim(i);
        }
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key max(){
        return pq[1];
    }

    public Key delMax(){
        Key max = pq[1];
        pq[1] = pq[N--];
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k){
        while (k/2 >= 1 && less(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while(k <= N/2){
            int j = 2 * k;
            if (j < N && less(j, j + 1))j++;
            if (less(j, k))break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }
}
