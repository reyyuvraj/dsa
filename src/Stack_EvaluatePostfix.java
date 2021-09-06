import java.util.Stack;

public class Stack_EvaluatePostfix {

    static int postfix(String s)
    {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
                st.push(s.charAt(i)-'0');
            else
            {
                int a = st.pop();
                int b = st.pop();
                switch (s.charAt(i)) {
                    case '+' -> st.push(b + a);
                    case '-' -> st.push(b - a);
                    case '*' -> st.push(b * a);
                    case '/' -> st.push(b / a);
                }
            }
        }
        return st.pop();
    }

    public static void main(String[] args)
    {
        String str = "231*+9-";//for single digit calculation

        System.out.println("Result is : "+postfix(str) );
    }
}
