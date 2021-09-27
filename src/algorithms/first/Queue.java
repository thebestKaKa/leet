package algorithms.first;

import java.util.Iterator;

public class Queue<Item> implements Iterable{
    // 使用链表实现队列
    private Node first;
    private Node last;
    private int N = 0;

    public Queue() {
        first = null;
        last  = null;
        N = 0;
    }

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){return first == null;}

    public int size(){return N;}

    public void enqueue(Item item){
        Node new_last = new Node();
        new_last.item = item;
        new_last.next = null;
        // if (isEmpty())
        if (last == null){
            last = new_last;
            first = new_last;
        }
        else {
            last.next = new_last;
            last = new_last;
        }
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        // 如果队列中只有一个节点 要处理好last
        // if (isEmpty())
        if (first == null){
            last = null;
        }
        N--;
        return item;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
