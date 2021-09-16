package sheet.stack;

import java.util.Stack;

public class Stack_PreviousGreaterElement {

    public static void printPreviousGreater(int[] arr, int n)
    {
        Stack<Integer> s = new Stack<>();
        s.add(arr[0]);
        for(int i=0;i<n;i++)
        {
            while(!s.isEmpty() && s.peek()<=arr[0])
                s.pop();
            int res = s.isEmpty()?-1 : s.peek();
            System.out.print(res+" ");
            s.add(arr[i]);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{20,30,10,5,15};
        printPreviousGreater(arr,arr.length);
    }
}
