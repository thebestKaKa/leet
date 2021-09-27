package algorithms.search_third;

import algorithms.first.Queue;

public class SeparateChainingHashST<Key, Value> {
    private int M;
    private SequentialSearchST<Key, Value>[] sequentialSearchST;

    public SeparateChainingHashST(){
        this.M = 997;
    }

    public SeparateChainingHashST(int M){
        this.M = M;
        sequentialSearchST = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
        //java不允许创造泛型数组
        for (int i = 0; i < M; i++) {
            sequentialSearchST[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value value){
        sequentialSearchST[hash(key)].put(key, value);
    }

    public Value get(Key key){
        return sequentialSearchST[hash(key)].get(key);
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < sequentialSearchST.length; i++) {
            for (Key key: sequentialSearchST[i].keys()){
                queue.enqueue(key);
            }
        }
//        for (SequentialSearchST<Key, Value> keyValueSequentialSearchST : sequentialSearchST) {
//            Iterable<Key> q = keyValueSequentialSearchST.keys();
//            Iterator<Key> keys = q.iterator();
//            while (keys.hasNext()){
//                queue.enqueue(keys.next());
//            }
//        }
        return queue;
    }
}
