package algorithms;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{
    // 手写动态调整数组大小实现的下压栈 p88
    private Item[] a = (Item[])(new Object[1]);
    //private int N;
    private int N = 0;

    public int size() {
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    private void resize(int length){
        Item[] temp = (Item[])(new Object[length]);
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item){
        if (N == a.length) resize(a.length*2);
        a[N++] = item;
    }

    public Item pop(){
        Item temp = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

    }

}
