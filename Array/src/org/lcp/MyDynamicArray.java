package org.lcp;

/**
 * @Author: LCP
 * @Date: 2018/07/14
 * @Description: 利用java静态数组，二次封装属于自己的动态数组
 */
public class MyDynamicArray<E> {

    private E[] arrary;
    private int size; //指向下一个空位置

    /**
     * @Description: 构造一个大小为capacity的数组
     * @param capacity
     */
    public MyDynamicArray(int capacity) {
        this.arrary = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * @Description: 默认容量为10
     */
    public MyDynamicArray() {
        this(10);
    }

    /**
     * 数组动态分配（缩容或者扩容）
     * @return
     */
    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++ ) {
            newArray[i] = this.arrary[i];
        }
        this.arrary = newArray;
    }

    //获取元素数量
    public int getSize() {
        return this.size;
    }

    //获取数组容量
    public int getCapacity() {
        return this.arrary.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向所有元素后添加一个元素
    public void addLast(E e) {
        //方法复用
        add(size, e);

        /*
        if (size > arrary.length) {
            throw new IllegalArgumentException("数组已满!");
        }
        arrary[size] = e;
        size++;
        */
    }

    //向头部插入
    public void addFirst(E e) {
        add(0, e);
    }

    //指定位置插入元素
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Required index > 0 and index < size");
        }
        if (size == arrary.length) {
            resize(arrary.length * 2);
        }

        for (int i = size - 1; i >= index; i--) {
            arrary[i+1] = arrary[i];
        }
        arrary[index] = e;
        size++;
    }

    //获取元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Required index > 0 and index < size");
        }
        return arrary[index];
    }
    //更新元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Required index > 0 and index < size");
        }
        arrary[index] = e;
    }
    //输出数组信息
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d \n", size, arrary.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(arrary[i]);
            if (i != size -1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    //搜索元素（是否存在）
    public boolean contains(E e) {

        for (int i = 0; i < size; i++) {
            if (arrary[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //寻找元素的索引
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (arrary[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    //查询所有重复元素的索引
    public String findAll(E e) {
        StringBuilder index = new StringBuilder();
        index.append(String.format("查询结果:\n"));
        for (int i = 0; i < size; i++) {
            if (arrary[i].equals(e)) {
                index.append(i+" ");
            }
        }
        return index.toString();
    }

    /**
     *
     * @param e 指定元素
     * @param all true: 删除全部， 否：只保留一个
     * @return
     */
    public String removeDuplicate(E e, boolean all ) {
        StringBuilder ele = new StringBuilder();

        int counter = 0;
        int firstIndex = find(e);

        if (firstIndex == -1) {
            throw new IllegalArgumentException("数组中没有此元素");
        }

        ele.append(String.format("已删除元素： \n"));
        for (int i = 0; i < size; i++) {
            if (arrary[i].equals(e)) {
                counter ++;
                if (counter == 2) {
                    remove(i);
                    ele.append("下标："+i + "; 值："+arrary[i]+" ");
                    counter --;
                }
            }
        }

        if (all) {
            ele.append("下标："+firstIndex + "; 值："+arrary[firstIndex]);
            remove(firstIndex);
        }

        return ele.toString();
    }



    //去重
    //标记
    public void unique() {
        for (int i = 0; i < size; i++) {
            removeDuplicate(arrary[i], false);
        }
    }

    //删除指定位置的元素，并返回删除的元素
    public E remove(int index) {
        //判断是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("数组为空，无法删除");
        }
        //判断index的合法性
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Unreachable element.");
        }
        E temp = arrary[index];
        for (int i = index+1; i < size; i ++) {
            arrary[i - 1] = arrary[i];
        }
        size --;
        arrary[size] = null;

        //缩容
        if (size == arrary.length / 2 && arrary.length / 2 != 0) {
            resize(arrary.length / 2);
        }
        return temp;
    }
    //删头
    public E removeFirst() {
        return remove(0);
    }
    //删尾
    public E removeLast() {
        return remove(size -1);
    }
}
