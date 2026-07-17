package stacks;

import java.util.Deque;
import java.util.ArrayDeque;

public class MyQueue_0232_BruteForce {
    // 入队用
    Deque<Integer> stackLeft = new ArrayDeque<>();
    // 出队用
    Deque<Integer> stackRight = new ArrayDeque<>();

    public MyQueue_0232_BruteForce() {

    }

    public void push(int x) {
        stackLeft.push(x);
    }

    public int pop() {
        while (!stackLeft.isEmpty()) {
            stackRight.push(stackLeft.pop());
        }
        int result = stackRight.pop();
        while (!stackRight.isEmpty()) {
            stackLeft.push(stackRight.pop());
        }
        return result;
    }

    public int peek() {
        while (!stackLeft.isEmpty()) {
            stackRight.push(stackLeft.pop());
        }
        int result = stackRight.peek();
        while (!stackRight.isEmpty()) {
            stackLeft.push(stackRight.pop());
        }
        return result;
    }

    public boolean empty() {
        return stackLeft.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue_0232_BruteForce obj = new MyQueue_0232_BruteForce();

        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
