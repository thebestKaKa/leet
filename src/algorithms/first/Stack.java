package algorithms.first;

import java.util.Iterator;

public class Stack<Item> implements Iterable{
    // 使用链表实现栈
    private Node first;
    private int N = 0;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){return first == null;}

    public int size(){return N;}

    public void push(Item item){
        // 别名？
        Node old_first = new Node();
        old_first.item = first.item;
        old_first.next = first.next;
        /*
         * Node old-first = first
         * first = new Node();
         * */
        first.item = item;
        first.next = old_first;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
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
