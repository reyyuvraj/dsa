package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack_BalancedParenthesis {

    public  static boolean matching(char a, char b)
    {
        return ((a=='(' && b==')') ||
                (a=='{' && b=='}') ||
                (a=='[' && b==']'));
    }

    public static boolean isBalanced(String str)
    {
        Deque<Character> s = new ArrayDeque<>();

        for(int i=0;i<str.length();i++)
        {
            char x = str.charAt(i);
            if(x=='(' || x=='{' || x=='[')
                s.push(x);
            else
            {
                System.out.println(s.peek());
                if(!s.isEmpty())
                    return false;
                else if(matching(s.peek(), x))
                    return false;
                else
                    s.pop();
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args)
    {
        String str = "()";
        if(isBalanced(str))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}