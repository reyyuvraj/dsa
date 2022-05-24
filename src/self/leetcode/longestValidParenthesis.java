package self.leetcode;

import java.util.Stack;

public class longestValidParenthesis {

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.empty()) stack.push(i);
                else max = Math.max(max, i - stack.peek());
            }
        }

        return max;
    }
}
