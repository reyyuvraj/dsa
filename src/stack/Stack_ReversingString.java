package stack;

import java.util.Stack;

public class Stack_ReversingString {

    public static void reverseString(String s){
        Stack<Character> cs = new Stack<>();
        for(int i=0;i<s.length();i++)
            cs.add(s.charAt(i));
        for(int i=0;i<s.length();i++)
            System.out.print(cs.pop());
    }

    public static void main(String[] args){
        String str = "Hello";
        reverseString(str);
    }
}
