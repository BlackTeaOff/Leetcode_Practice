package stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class RemoveDuplicates_1047 {
    public static class Solution {
        public String removeDuplicates(String s) {
            Deque<Character> deque = new ArrayDeque<>();
            char[] cs = s.toCharArray();
            // 遍历char数组比String的方法charAt快
            for (char c : cs) {
                if (deque.peek() != null && c == deque.peek()) {
                    deque.pop();
                    continue;
                }
                deque.push(c);
            }
            StringBuilder sb = new StringBuilder();
            // 增强for循环默认用正向遍历迭代器
            // for (char c : deque) {
            //     sb.append(c);
            // }

            // 手动用倒序迭代器
            Iterator<Character> it = deque.descendingIterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
    }
}
