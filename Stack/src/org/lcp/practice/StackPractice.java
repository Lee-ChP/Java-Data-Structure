package org.lcp.practice;

import org.lcp.ArrayStack;

import java.util.Scanner;

/**
 * @Leetcode:
 * @Number: 20
 * @Desc: 括号开闭匹配。正确：【】 「」 {} {{(【】)}}; 错误：【』 【} 等
 */
public class StackPractice {

    /**
     *  解决方法：
     *  左括号，全部入栈。右括号匹配栈顶。匹配成功pop
     * @param args
     */

    static ArrayStack<Character> arrayStack = new ArrayStack<>();

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        String parenthesis;
        boolean endFlag = false;

        String msg = null;
        char c ;

        while (true) {
            if (endFlag == true) {
                break;
            }
            System.out.println("请输入: ");
            parenthesis = in.nextLine();


            for (int i = 0; i < parenthesis.length(); i++) {
                c = parenthesis.charAt(i);
                // JDK1.7前不支持String
                switch (c) {
                    case '{':
                        arrayStack.push('{');
                        break;

                    case '[':
                        arrayStack.push('[');
                        break;

                    case '(':
                        arrayStack.push('(');
                        break;

                    case '}':
                        msg = match('{');
                        endFlag = end();
                        break;

                    case ']':
                        msg = match('[');
                        endFlag = end();
                        break;

                    case ')':
                        msg = match('(');
                        endFlag = end();
                        break;

                    default:
                        break;
                }
            }
        }
        System.out.println("结果： "  + msg);
    }

    public static String match(char tag) {

        if (arrayStack.isEmpty()) {
            return "Mismatch";
        }
        if (arrayStack.pop().equals(tag)) {
            return "Match";
        } else {
            return "Mismatch";
        }
    }

    public static boolean end() {

        if (arrayStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


}
