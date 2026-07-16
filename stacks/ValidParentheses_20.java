package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses_20 {
    static class Solution {
        public boolean isValid(String s) {
            Deque<Character> deque = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                    deque.push(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    if (deque.isEmpty() || deque.pop() != '(') {
                        return false;
                    }
                } else if (s.charAt(i) == '}') {
                    if (deque.isEmpty() || deque.pop() != '{') {
                        return false;
                    }
                } else if (s.charAt(i) == ']') {
                    if (deque.isEmpty() || deque.pop() != '[') {
                        return false;
                    }
                }
            }
            if (!deque.isEmpty()) {
                return false;
            }
            // 这里可以直接return deque.isEmpty()
            return true;
        }

        public boolean isValid2(String s) {
            Deque<Character> deque = new ArrayDeque<>();
            // 使用char[]比使用charAt稍微快一点
            for (char c : s.toCharArray()) {
                // 遇到括号直接将另一半入栈
                // 后面遇到另一半括号的时候直接出栈对比就行(除了括号没有其他符号)
                if (c == '(') {
                    deque.push(')');
                } else if (c == '{') {
                    deque.push('}');
                } else if (c == '[') {
                    deque.push(']');
                    // 遇到右括号先判空, 再对比即可
                } else if (deque.isEmpty() || deque.pop() != c) {
                    return false;
                }
            }
            return deque.isEmpty();
        }
    }    

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "]";        
        System.out.println(solution.isValid(test));
    }
}


