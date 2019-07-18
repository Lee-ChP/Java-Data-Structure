package org.lcp;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyDynamicArray<Integer> myDynamicArray = new MyDynamicArray<>(1);
        MyDynamicArray<String> myDynamicArray2 = new MyDynamicArray<>(3);

        System.out.println("扩容前： " + myDynamicArray.getCapacity());
        System.out.println("数组2扩容前： " + myDynamicArray2.getCapacity());

        //尾插
        myDynamicArray.addLast(21);
        myDynamicArray.addLast(22);
        myDynamicArray.addLast(23);
        myDynamicArray.addLast(24);


        System.out.println("扩容后： " + myDynamicArray.getCapacity());

        myDynamicArray2.addLast("小米");
        myDynamicArray2.addLast("小黄");
        myDynamicArray2.addLast("小红");
        myDynamicArray2.addLast("小白");
        myDynamicArray2.addLast("小米");
        myDynamicArray2.addLast("小黄");
        myDynamicArray2.addLast("小红");
        myDynamicArray2.addLast("小白");

        System.out.println("数组2扩容后： " + myDynamicArray2.getCapacity());

        //头插
        myDynamicArray.addFirst(100);
        //指定位置
        myDynamicArray.add(2,110);
        System.out.println(myDynamicArray);
        //查询指定位置的元素
        int pos = myDynamicArray.get(3);
        System.out.println("Should be 22 and rs is ： " + pos);

        //修改指定位置的元素
        myDynamicArray.set(2, -100);
        //搜索元素是否在数组中
        System.out.println(myDynamicArray.contains(22) + " :: " + myDynamicArray.contains(1000));
        //搜索元素的索引
        System.out.println(myDynamicArray.find(23) + " :: " + myDynamicArray.find(1000));
        //删除指定元素并返回
        System.out.println(myDynamicArray.remove(2));

        // 删头
        System.out.println(myDynamicArray.removeFirst());

        //删尾
        System.out.println(myDynamicArray.removeLast());

        System.out.println(myDynamicArray);
        //空数组删除错误测试
        //System.out.println(myDynamicArray2.remove(1));

        System.out.println("=============================");
        System.out.println("去重前：\n"+myDynamicArray2);
        //查询重复元素的下标
        System.out.println(myDynamicArray2.findAll("小黄"));
        //删除重复元素，为true的时候删除，为false的时候保留一个，做去重处理
        //System.out.println(myDynamicArray2.removeDuplicate(23, true));
        //所有元素去重
        myDynamicArray2.unique();

        System.out.println("去重后\n"+ myDynamicArray2);
        System.out.println("去重后数组2缩容： " + myDynamicArray2.getCapacity());


    }

}