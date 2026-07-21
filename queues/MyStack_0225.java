package queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack_0225 {
    Deque<Integer> deque = new ArrayDeque<>();

    public MyStack_0225() {
    }

    // 也可以把旋转的策略放到push里
    // 这样push为O(N)
    // 其他两个为O(1)
    public void push(int x) {
        deque.offer(x);
    }

    public int pop() {
        for (int i = 0; i < deque.size() - 1; i++) {
            deque.offer(deque.poll());
        }
        return deque.poll();
    }

    public int top() {
        for (int i = 0; i < deque.size() - 1; i++) {
            deque.offer(deque.poll());
        }
        int result = deque.peek();
        deque.offer(deque.poll());
        return result;
    }

    public boolean empty() {
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        MyStack_0225 myStack = new MyStack_0225();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
