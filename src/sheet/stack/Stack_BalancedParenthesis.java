package sheet.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Stack_BalancedParenthesis {

    public static boolean matching(char a, char b) {
        return ((a == '(' && b == ')') ||
                (a == '{' && b == '}') ||
                (a == '[' && b == ']'));
    }

    public static boolean isBalanced(String str) {
        Deque<Character> s = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(' || x == '{' || x == '[')
                s.push(x);
            else {
                System.out.println(s.peek());
                if (s.isEmpty())
                    return false;
                else if (!matching(s.peek(), x))
                    return false;
                s.pop();
            }
        }
        return s.isEmpty();
    }

    public static boolean balanced(String s){
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch=='(')
                st.push(')');
            else if (ch=='{')
                st.push('}');
            else if (ch=='[')
                st.push(']');
            else if (st.isEmpty() || st.pop()!=ch)
                return false;

        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()";
        if (balanced(str))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}