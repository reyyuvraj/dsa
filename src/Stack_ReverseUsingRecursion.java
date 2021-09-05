import java.util.Stack;

public class Stack_ReverseUsingRecursion {

    static Stack<Character> st=new Stack<>();

    static void insertAtBottom(char x)
    {
        if(st.isEmpty())
            st.push(x);
        else
        {
            char a = st.peek();
            st.pop();
            insertAtBottom(x);
            st.push(a);
        }
    }

    static void reverse()
    {
        if (st.size()>0)
        {
            char x = st.peek();
            st.pop();
            reverse();
            insertAtBottom(x);
        }
    }

    public static void main(String[] args)
    {
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');

        System.out.print("Original Stack : ");
        System.out.println(st);

        reverse();
        System.out.print("Reversed Stack : ");
        System.out.println(st);

    }
}
