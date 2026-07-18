package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack_0155 {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack_0155() {

    }

    // public void push(int value) {
    //     if (minStack.isEmpty()) {
    //         stack.push(value);
    //         minStack.push(value);
    //         return;
    //     } else {
    //         if (value <= minStack.peek()) {
    //             minStack.push(value);
    //         }
    //         stack.push(value);
    //     }
    // }

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    } 

    public void pop() {
        // stack.pop返回Integer对象, == 比较对象相不相等
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack_0155 MinStack = new MinStack_0155();
        MinStack.push(512);
        MinStack.push(-1024);
        MinStack.push(-1024);
        MinStack.push(512);
        MinStack.pop();
        System.out.println(MinStack.getMin());
        MinStack.pop();
        System.out.println(MinStack.getMin());
        MinStack.pop();
        System.out.println(MinStack.getMin());
    }
}
