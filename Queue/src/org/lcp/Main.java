package org.lcp;

import org.lcp.queue.ArrayQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(2);
        //空队列
        System.out.println("空队列： " + arrayQueue.isEmpty());

        //入队
        arrayQueue.enQueue("我是队长，我第一个出来");
        arrayQueue.enQueue("后备队长路人甲");
        arrayQueue.enQueue("后备队长路人甲的后备队长路人乙");
        arrayQueue.enQueue("吊车尾路人丙");

        System.out.println("还是空队列么 ： " + arrayQueue.isEmpty());
        System.out.println("队伍长度： " + arrayQueue.getSize());

        //队长
        System.out.println("第一任队长： " + arrayQueue.getFront());

        //一个个滚出队伍来

        while (!arrayQueue.isEmpty()) {
            System.out.println("我是现任队长： " + arrayQueue.deQueue() + " , 我溜了！");
            System.out.println("下一任队长是： " + arrayQueue.getFront());
            System.out.println("队伍情况： " + arrayQueue);
        }

        //对内情况
    }
}
