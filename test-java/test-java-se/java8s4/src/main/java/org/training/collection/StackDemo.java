package org.training.collection;

import java.util.Stack;

/**
 * Created by kongyunlong on 2017/8/27.
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("aaa");
        stack.push("abc");
        stack.push("123");
        stack.push("456");
        stack.push("===");
        System.out.println(stack.peek());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.search("abc"));
        System.out.println(stack.size());
    }
}
