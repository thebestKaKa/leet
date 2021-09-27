package algorithms.search_third;

import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    //二叉查找树
    private Node root;

    private class Node{
        Key key;
        Value value;
        Node left, right;
        int N;
        public Node(Key key, Value value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    public int size(Node x){
        if (x == null)return 0;
        return x.N;
    }

    public void put(Key key, Value value){
        put(root, key, value);
    }

    public Node put(Node x, Key key, Value value){
        if (x == null)return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)x.left = put(x.left, key, value);
        else if (cmp > 0)x.right = put(x.right, key, value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value get(Key key){
        return get(root, key).value;
    }

    public Node get(Node x, Key key){
        if (x == null)return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)return get(x.left, key);
        else if (cmp > 0)return get(x.right, key);
        else return x;
    }

    public Key max(){
        return max(root).key;
    }

    public Node max(Node x){
        if (x.right == null)return x;
        return max(x.right);
    }

    public Key min(){
        return min(root).key;
    }

    public Node min(Node x){
        if (x.left == null)return x;
        return min(x.left);
    }

    public Key floor(Key key){
        if (floor(root, key) == null)return null;
        return floor(root, key).key;
    }

    public Node floor(Node x, Key key){
        if (x == null)return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)return floor(x.left, key);
        else if (cmp == 0) return x;
        else {
            Node t = floor(x.right, key);
            if (t != null)return t;
            else return x;
        }
    }

    public Key ceiling(Key key){
        if (ceiling(root, key) == null)return null;
        return ceiling(root, key).key;
    }

    public Node ceiling(Node x, Key key){
        if (x == null)return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)return x;
        else if (cmp > 0)return ceiling(x.right, key);
        else {
            Node t = ceiling(x.left, key);
            if (t != null)return t;
            return x;
        }
    }

    public Key select(int k){
        if (select(root, k) == null)return null;
        return select(root, k).key;
    }

    public Node select(Node x, int k){
        if (x == null)return null;
        if (size(x.left) == k) return x;
        else if (size(x.left) > k)return select(x.left, k);
        else return select(x.right, k - size(x.left) - 1);
    }

    public int rank(Key key){
        if (key == null)return -1;
        return rank(root, key);
    }

    public int rank(Node x, Key key){
        if (x == null)return 0;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)return size(x.left);
        else if (cmp < 0)return rank(x.left, key);
        else {
            return size(x.left) + 1 + rank(x.right, key);
        }
    }

    public void deleteMax(){
        root = deleteMax(root);
    }

    public Node deleteMax(Node x){
        if (x == null)return null;
        if (x.right == null)return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    public Node deleteMin(Node x){
        if (x == null)return null;
        if (x.left == null)return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    public Node delete(Node x, Key key){
        if (x == null)return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.left == null) return x.right;
            if (x.right == null)return x.left;
            Node t = min(x.right);
            t.left = x.left;
            t.right = deleteMin(x.right);
            x = t;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key low, Key high){
        //中序遍历
        Queue<Key> q = new LinkedList<>();
        keys(root, q, low, high);
        return q;
    }

    public void keys(Node x, Queue<Key> q, Key low, Key high){
        if (x == null)return;
        int cmpOfLow = low.compareTo(x.key);
        int cmpOfHigh = high.compareTo(x.key);
        if (cmpOfLow < 0) keys(x.left, q, low, high);
        if (cmpOfLow <= 0 && cmpOfHigh >= 0)q.add(x.key);
        if (cmpOfHigh > 0) keys(x.right, q, low, high);
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }
}

