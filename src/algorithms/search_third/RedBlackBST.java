package algorithms.search_third;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    //红黑树
    private Node root;
    private int N;
    private final boolean RED = true;
    private final boolean BLACK = false;

    private class Node{
        Key key;
        Value value;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value value, int N, boolean color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    public boolean isEmpty(){
        return size(root) == 0;
    }

    public int size(){
        return size(root);
    }

    public int size(Node x){
        if (x == null)return 0;
        return x.N;
    }

    private boolean isRed(Node x){
        if (x == null)return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        x.N = h.N;
        h.color = RED;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        x.N = h.N;
        h.color = RED;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    public void flipColors(Node h){
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
        h.color = !h.color;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value value){
        if (x == null)return new Node(key, value, 1, RED);
        int cmp =  key.compareTo(x.key);
        if (cmp < 0)x.left = put(x.left, key, value);
        else if (cmp > 0)x.right = put(x.right, key, value);
        else x.value = value;
        if (isRed(x.right) && !isRed(x.left))rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left))rotateRight(x);
        if (isRed(x.right) && isRed(x.left))flipColors(x);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node moveRedLeft(Node x){
        flipColors(x);
        if (isRed(x.right.left)){
            x.right = rotateRight(x.right);
            x = rotateLeft(x);
        }
        return x;
    }

    public void deleteMin(){
        if (!isRed(root.left))root.color = RED;
        root = deleteMin(root);
        if (!isEmpty())root.color = BLACK;
    }

    private Node deleteMin(Node x){
        if (x.left == null)return null;
        if (!isRed(x.left) && !isRed(x.left.left)){
            x = moveRedLeft(x);
        }
        x.left = deleteMin(x.left);
        return balance(x);
    }

    private Node moveRedRight(Node x){
        flipColors(x);
        if (isRed(x.left.left)){
            x = rotateRight(x);
        }
        return x;
    }

    public void deleteMax(){
        if (!isRed(root.left))root.color = RED;
        root = deleteMax(root);
        if (!isEmpty())root.color = BLACK;
    }

    public Node deleteMax(Node x){
        if (isRed(x.left))x = rotateRight(x);
        if (x.right == null)return null;
        if (!isRed(x.right) && !isRed(x.right.left)){
            x = moveRedRight(x);
        }
        x.right = deleteMax(x.right);
        return balance(x);
    }

    private Node balance(Node x){
        if (isRed(x.right))x = rotateLeft(x);
        if (isRed(x.right) && !isRed(x.left))x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left))x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right))flipColors(x);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        if (!isRed(root.left))root.color = RED;
        root = delete(root, key);
        if (!isEmpty())root.color = BLACK;
    }

    private Node delete(Node x, Key key){
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            if (!isRed(x.left) && !isRed(x.left.left)){
                x = moveRedLeft(x);
            }
            x.left = delete(x.left, key);
        }else {
            if (isRed(x.left))x = rotateRight(x);
            if (key.compareTo(x.key) == 0 && x.right == null)return null;
            if (!isRed(x.right) && !isRed(x.right.left)){
                x = moveRedRight(x);
            }
            if (key.compareTo(x.key) == 0){
                x.value = min(x.right).value;
                x.key = min(x.right).key;
                x.right = deleteMin(x.right);
            }else x.right = delete(x.right, key);
        }
        return balance(x);
    }

    private Node min(Node x){
        if (x.left == null)return x;
        return min(x.left);
    }

    private Node get(Node x, Key key){
        if (x == null)return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)return get(x.left, key);
        else if (cmp > 0)return get(x.right, key);
        else return x;
    }
}
