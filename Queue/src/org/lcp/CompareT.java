package org.lcp;

import org.lcp.queue.ArrayQueue;
import org.lcp.queue.LoopQueue;

import java.util.Random;

/**
 * 比较循环队列与单向队列的速度
 */
public class CompareT {

    public static void main(String[] args) {

        int opCount = 1000000;

        long startTime1 = System.nanoTime();
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(opCount);
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        Random random = new Random();

        for (int i = 0 ; i < opCount; i++) {
            //入
            arrayQueue.enQueue(random.nextInt(Integer.MAX_VALUE));

        }
        for (int i = 0; i< arrayQueue.getSize(); i++) {
            //取
            arrayQueue.deQueue();
        }
        long endTime1 = System.nanoTime();

        double total1 = (endTime1 - startTime1) / 100000000.0;



        long startTime2 = System.nanoTime();

        for (int i = 0 ; i < opCount; i++) {
            //入
            loopQueue.enQueue(random.nextInt(Integer.MAX_VALUE));

        }

        for (int i = 0; i < loopQueue.getSize(); i++) {
            //取
            loopQueue.deQueue();
        }

        long endTime2 = System.nanoTime();
        double total2 = (endTime2 - startTime2) / 100000000.0;

        System.out.println("100万次出入队列耗时：");
        System.out.println("循环队列： " + total2 + "秒");
        System.out.println("单向队列： " + total1 + "秒");

    }
}
