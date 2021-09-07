package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N = 0;

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public void put(Key key, Value value){
        int id = rank(key);
        if (id < N && keys[id].compareTo(key) == 0){
            values[id] = value;
            return;
        }
        for (int i = N; i > id; i--) {//i > id >= 0
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[id] = key;
        values[id] = value;
        N++;
    }

    public Value get(Key key){
        int id = rank(key);
        if (id < N && keys[id].compareTo(key) == 0)return values[id];
        else return null;
    }

    public void delete(Key key){
        int id = rank(key);
        for (int i = id; i < N - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        N--;
        keys[N] = null;
        values[N] = null;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public int size(){return N;}

    public int size(Key low, Key high){
        if (contains(high))return rank(high) - rank(low) + 1;
        else return rank(high) - rank(low);
    }

    public boolean isEmpty(){return N == 0;}

    public void deleteMax(){
        delete(max());
    }

    public void deleteMin(){
        delete(min());
    }

    public Key floor(Key key){
        //小于等于key的最大键
        if (contains(key)) return keys[rank(key)];
        else return keys[rank(key) - 1];
    }

    public Key ceiling(Key key){
        //大于等于key的最小键
        return keys[rank(key)];
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N - 1];
    }

    public int rank(Key key){
        //二分查找
        int low = 0, high = N - 1;
        while (low <= high){
            int mid = (low + high)/2;
            if (keys[mid].compareTo(key) < 0)low = mid + 1;
            else if (keys[mid].compareTo(key) > 0) high = mid - 1;
            else return mid;
        }
        return low;
    }

    public Key select(int k){
        return keys[k];
    }

    public Iterable keys(){
        return keys(select(0), select(N - 1));
    }

    public Iterable keys(Key low, Key high){
        Queue<Key> q = new LinkedList<>();
        for (int i = rank(low); i < rank(high); i++) {
            q.add(keys[i]);
        }
        if (contains(high))q.add(high);
        return q;
    }
}
