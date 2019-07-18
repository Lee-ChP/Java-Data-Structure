package org.lcp.queue;

public class LoopQueueTest {

    public static void main(String[] args) {

        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        //是否为空：
        System.out.println("队列是否为空: " + loopQueue.isEmpty());

        //队尾不转向测试
        //入队操作
        for (int i = 0 ; i < 10; i++) {
            loopQueue.enQueue(i*10);
            System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
            System.out.println(loopQueue);

        }
        //正向扩容测试：
        for (int i = 11; i < 22 ; i ++) {
            System.out.println("正向扩容测试：");
            loopQueue.enQueue(i*11);
            System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
            System.out.println(loopQueue);
        }
        //出队操作
        System.out.println("\n" + "出队操作： " + "\n原队列:\n"+loopQueue);
        System.out.println("出队元素为: " + loopQueue.deQueue());
        System.out.println(loopQueue);

        System.out.println("\n" + "出队操作： " + "\n原队列:\n"+loopQueue);
        System.out.println("出队元素为: " + loopQueue.deQueue());
        System.out.println(loopQueue);

        System.out.println("\n" + "出队操作： " + "\n原队列:\n"+loopQueue);
        System.out.println("出队元素为: " + loopQueue.deQueue());
        System.out.println(loopQueue);

        System.out.println("\n" + "出队操作： " + "\n原队列:\n"+loopQueue);
        System.out.println("出队元素为: " + loopQueue.deQueue());
        System.out.println(loopQueue);

        //重新入队，队尾转向
        System.out.println("队尾转向: ============================");

        loopQueue.enQueue(2000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);

        loopQueue.enQueue(3000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(4000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(5000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(6000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(7000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(8000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(9000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);

        System.out.println("\n" + "出队操作： " + "\n原队列:\n"+loopQueue);
        System.out.println("出队元素为: " + loopQueue.deQueue());
        System.out.println(loopQueue);
        System.out.println("\n" + "出队操作： " + "\n原队列:\n"+loopQueue);
        System.out.println("出队元素为: " + loopQueue.deQueue());
        System.out.println(loopQueue);
        System.out.println("\n" + "出队操作： " + "\n原队列:\n"+loopQueue);
        System.out.println("出队元素为: " + loopQueue.deQueue());
        System.out.println(loopQueue);

        loopQueue.enQueue(10000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(11000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(12000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(13000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(14000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(15000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(16000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);
        loopQueue.enQueue(17000);
        System.out.println("此时队列元素数量为：" + loopQueue.getSize() + " ; 总容量为： " + loopQueue.getCapacity());
        System.out.println(loopQueue);





    }
}
