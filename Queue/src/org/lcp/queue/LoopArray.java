package org.lcp.queue;

public class LoopArray<E>  {

    private E[] array;
    private int front;
    private int tail;
    private int size;


    public LoopArray(int capacity){
        this.array = (E[]) new Object[capacity+1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopArray() {
        this(10);
    }

    //添加
    public void add(int index, E e) {
        if (index < 0 || index > this.array.length) {
            throw new IllegalArgumentException("Unreachable Element at index :  " + index);
        }
        this.array[index] = e;
        this.size++;
    }

    //数组末尾添加元素
    public void addLast(E e) {
        //判满扩容
        if ((this.tail+1) % this.array.length == this.front) {
            //扩容前把元素添加到末尾
            add(this.tail, e);
            resize(this.array.length * 2 - 1);
        } else if(this.tail == this.array.length - 1) { //tail到达末尾，需要转向
            //转向前把元素添加到末尾
            add(this.tail, e);
            this.tail = (tail+1) % this.array.length;
        } else {
            add(this.tail, e);
            this.tail++;
        }

    }

    //查看数组首元素
    public E getFirst() {
        return this.array[this.front];
    }
    //移除并返回数组开头元素
    public E removeFirst() {
        if (this.front == this.tail) {
            throw new IllegalArgumentException("Can not get element from an empty queue .");
        }
        E ret = this.array[this.front];

        this.array[this.front] = null;
        this.size--;
        //队首指向下一位
        if ((this.front+1) >= this.array.length) {
            this.front %= this.array.length;
        } else {
            this.front++;
        }
        return ret;
    }

    //获取循环队列元素长度
    public int getSize() {
        return this.size;
    }
    //获取队列容量
    public  int getCapacity() {
        return this.array.length;
    }

    //扩容
    public void resize(int capacity) {

        //System.out.println("开始扩容：");
        //System.out.println(this.toString());
        E[] newArray = (E[]) new Object[capacity];
        int next = this.front;
        int last = 0; //记录newArray的末尾元素的索引
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.array[next];
            last++;
            next++;
            if (next > this.array.length - 1) {
                //this.array = newArray;
                //System.out.println("front部分扩容完毕： " + this.toString());
                break;
            }
        }
        //原数组tail转向
        if (this.tail < this.front) {
            //System.out.println("扩容： tail " + this.tail + " 此时： last " + last);
            for (int i = 0; i <= this.tail; i++) {
                newArray[last] = this.array[i];
                last++;
            }
        }

        this.array = newArray;
        this.front = 0;
        this.tail = last;
    }

    //数组判空
    public boolean isEmpty() {
        return this.front == this.tail;
    }

    //打印
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("队首索引："+this.front + ", "+"队首元素： " + this.getFirst() + ";\n"));
        stringBuilder.append("[");
        for (int i = 0 ; i < this.array.length; i++) {
            stringBuilder.append(this.array[i]);
            if (i != this.array.length-1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }




 }
