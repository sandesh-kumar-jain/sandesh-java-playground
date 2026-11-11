package com.sandesh.sandesh_java_playground.string;
import java.util.Stack;
public class StackStringReversal {
    public static void main(String[] args) {
        String str = "Sandesh";
        System.out.println(reverseWithStack(str));
    }
    public static String reverseWithStack(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}
