package org.lcp;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayStack<String> myStack = new ArrayStack();
        System.out.println("栈为空么： " + myStack.isEmpty());
        myStack.push("元素1，我是栈底，因为我第一个进");
        myStack.push("元素2，栈中间元素");
        myStack.push("元素3，栈中间元素");
        myStack.push("元素4，栈中间元素");
        myStack.push("元素5，我是栈顶，因为我最后一个进");

        System.out.println("栈还为空么： " + myStack.isEmpty());
        System.out.println("栈内部： " + myStack);
        System.out.println("栈大小： " + myStack.getSize());

        System.out.println("准备出栈： ");

        while (myStack.getSize() != 1) {
            System.out.println("前栈顶元素: " + myStack.pop());
            System.out.println("现栈顶元素: " + myStack.peek());
            System.out.println("现在的栈： " + myStack);
            System.out.println("===============================");
        }

    }
}
