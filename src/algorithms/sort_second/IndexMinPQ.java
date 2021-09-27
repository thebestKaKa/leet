package algorithms.sort_second;

public class IndexMinPQ<Key extends Comparable<Key>> {
    //索引优先队列
    private int[] pq;//索引二叉树
    private int[] qp;//存放索引
    private Key[] Keys;
    private int N;

    public IndexMinPQ(int maxN){
        N = 0;
        Keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    public void insert(int k, Key key){
        N++;
        pq[N] = k;
        qp[k] = N;
        Keys[k] = key;
        swim(N);
    }

    public void change(int k, Key key){
        Keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public boolean contain(int k){
        return qp[k] != -1;
    }

    public void delete(int k){
        exch(qp[k], N--);
        swim(qp[k]);
        sink(qp[k]);
        Keys[k] = null;
        qp[k] = -1;
    }

    public Key min(){
        return Keys[pq[1]];
    }

    public int minIndex(){
        return pq[1];
    }

    public int delMin(){
        int IndexMin = pq[1];
        exch(1, N--);
        //pq[N + 1] == IndexMin;
        sink(1);
        Keys[IndexMin] = null;
        qp[IndexMin] = -1;
        return IndexMin;
    }

    private void swim(int k){
        while (k > 1 && less(k, k/2)){
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while(k <= N/2){
            int j = 2 * k;
            if (j < N && less(j + 1, j))j++;
            if (less(k, j))break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        return Keys[pq[i]].compareTo(Keys[pq[j]]) < 0;
    }

    private void exch(int i, int j){
        //交换索引 同时修改逆序数组
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }


    public boolean isEmpty(){return N == 0;}

    public int size(){return N;}
}
