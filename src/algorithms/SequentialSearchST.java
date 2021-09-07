package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class SequentialSearchST<Key, Value> {
    //顺序查找表
    private int N = 0;
    private Node node;

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
        Node t = node;
        while (t != null){
            if (t.key.equals(key)){
                t.value = value;
                break;
            }
            t = t.next;
        }
        node = new Node(key, value, node);
        N++;
    }

    public Value get(Key key){
        Node t = node;
        while (t != null){
            if (t.key.equals(key)){ return t.value; }
            t = t.next;
        }
        return null;
    }

    public void delete(Key key){
        if (node == null)return;
        if (node.key.equals(key))node = node.next;
        Node t = node;
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

    public Iterable<Key> keys(Key low, Key high){
        Queue<Key> q = new LinkedList<>();
        Node t = node;
        while (t != null){
            if (t.key.equals(low)){
                while (t != null && !t.key.equals(high)){
                    q.add(t.key);
                    t = t.next;
                }
                if (t != null)q.add(t.key);
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
