package org.lcp.queue;

public interface Queue<E> {
    //入列
    void enQueue(E e);
    //出列
    E deQueue();
    //队列元素长度
    int getSize();
    //队首元素
    E getFront();
    //判空
    boolean isEmpty();
}
