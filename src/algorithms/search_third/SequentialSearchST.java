package algorithms.search_third;

import algorithms.first.Queue;

public class SequentialSearchST<Key, Value> {
    //顺序查找表
    private int N = 0;
    private Node root;

    private class Node{
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Key key, Value value){
//        for (Node x = node; x != null; x = x.next){
//            if (x.key.equals(key)){
//                x.value = value;return;
//            }
//        }
        Node t = root;
        while (t != null){
            if (t.key.equals(key)){
                t.value = value;
                break;
            }
            t = t.next;
        }
        root = new Node(key, value, root);
        N++;
    }

    public Value get(Key key){
        Node t = root;
        while (t != null){
            if (t.key.equals(key)){ return t.value; }
            t = t.next;
        }
        return null;
    }

    public void delete(Key key){
        if (root == null)return;
        if (root.key.equals(key)) root = root.next;
        Node t = root;
        while (t != null && t.next != null){
            if (t.next.key.equals(key)){
                t.next = t.next.next;
                N--;
                return;
            }
            t = t.next;
        }
    }

    public boolean contains(Key key){
        if (key == null) throw new IllegalArgumentException("该方法的参数是null！");
        return get(key) != null;
    }

    public Iterable<Key> keys(){
        Queue<Key> q = new Queue<Key>();
        for (Node node = root; node != null; node = node.next){
            q.enqueue(node.key);
        }
        return q;
    }

    public Iterable<Key> keys(Key low, Key high){
        Queue<Key> q = new Queue<>();
        Node t = root;
        while (t != null){
            if (t.key.equals(low)){
                while (t != null && !t.key.equals(high)){
                    q.enqueue(t.key);
                    t = t.next;
                }
                if (t != null)q.enqueue(t.key);
                return q;
            }
            t = t.next;
        }
        return q;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return  N == 0;
    }

}
