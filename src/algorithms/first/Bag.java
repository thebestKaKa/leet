package algorithms.first;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private int count;
    private Node first;

    private class Node{
        Item item;
        Node next;
        public Node(Item item){
            this.item = item;
        }
    }

    public void add(Item item){
        Node cur = new Node(item);
        cur.next = first;
        first = cur;
        count++;
    }

    public Iterator<Item> iterator(){
        return new ItemIterator();
    }

    private class ItemIterator implements Iterator<Item>{
        Node cur = first;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Item next() {
            Node node = cur;
            cur = cur.next;
            return node.item;
        }
    }
}
