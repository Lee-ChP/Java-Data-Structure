package org.lcp.queue;

import org.lcp.Array;

public class ArrayQueue<E> implements Queue<E> {

    Array<E> array ;

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayQueue() {
        this.array = new Array<>();
    }

    @Override
    public void enQueue(E e) {
        this.array.addLast(e);
    }

    @Override
    public E deQueue() {
        return this.array.removeFirst();
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public E getFront() {
        return this.array.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("top [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
