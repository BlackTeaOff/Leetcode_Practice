package queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecentCounter_0933 {
    Deque<Integer> deque = new ArrayDeque<>();

    public RecentCounter_0933() {

    }

    public int ping(int t) {
        while (!deque.isEmpty() && deque.peek() < t - 3000) {
            deque.poll();
        }
        deque.offer(t);
        return deque.size();
    }

    public static void main(String[] args) {
        RecentCounter_0933 recentCounter = new RecentCounter_0933();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
