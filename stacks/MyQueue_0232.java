package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue_0232 {
    // 收件箱
    Deque<Integer> inStack = new ArrayDeque<>();
    // 发件箱
    Deque<Integer> outStack = new ArrayDeque<>();

    public MyQueue_0232() {

    }

    // 入队直接push到收件箱里
    void push(int x) {
        inStack.push(x);
    }

    // pop或peek的时候如果发件箱为空
    // 就把收件箱里面的元素都放入发件箱
    // 这些元素就是需要pop或peek的队头
    // push和这些元素都没有关系了
    void dumpIfEmpty() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    int pop() {
        if (outStack.isEmpty()) {
            dumpIfEmpty();
        }
        return outStack.pop();
    }

    int peek() {
        if (outStack.isEmpty()) {
            dumpIfEmpty();
        }
        return outStack.peek();
    }

    boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
