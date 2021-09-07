import java.util.ListIterator;
import java.util.Stack;

public class Stack_SortUsingRecursion {

    static void sortInserted(Stack<Integer> s,int k)
    {
        if(s.isEmpty() || k>s.peek())
        {
            s.push(k);
            return;
        }

        int temp = s.pop();
        sortInserted(s,k);
        s.push(temp);
    }

    static void sortStack(Stack<Integer> s)
    {
        if(!s.isEmpty())
        {
            int x = s.pop();
            sortStack(s);
            sortInserted(s,x);
        }
    }

    static void printStack(Stack<Integer> s)
    {
        ListIterator<Integer> ls = s.listIterator();

        while(ls.hasNext())
            ls.next();

        while(ls.hasPrevious())
            System.out.print(ls.previous()+" ");
    }

    public static void main(String[] args)
    {
        Stack<Integer> st = new Stack<>();
        st.push(30);
        st.push(40);
        st.push(10);
        st.push(20);
        st.push(70);

        System.out.print("Stack before sorting : ");
        printStack(st);

        sortStack(st);

        System.out.println();
        System.out.print("Stack after sorting : ");
        printStack(st);
    }
}