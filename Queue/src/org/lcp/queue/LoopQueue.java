package org.lcp.queue;


/**
 * 循环队列
 * 要点:
 *          1: 声明指向队首的front和队尾下一个元素的tail
 *          2: 为了触发扩容，数组必须比声明的多一个位置
 *          3: 为了不浪费空间，tail转向的时候（即 front前面有空位可用），要先把元素填入最后多余的空间内
 *          4: 同样的触发扩容后，执行扩容之前，也要把元素先填入后一个空间
 *          5: 扩容后，原数组元素要按照队首到队尾的顺序一次填入扩容后的数组中去
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private LoopArray<E> array;

    public LoopQueue(int capacity) {
        this.array = new LoopArray<>(capacity);
    }

    public LoopQueue() {
        this.array = new LoopArray<>();
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

    public int getCapacity() {
        return this.array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public String toString() {
        return this.array.toString();
    }

}
