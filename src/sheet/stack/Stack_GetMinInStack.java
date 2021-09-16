package sheet.stack;

import java.util.Objects;
import java.util.Stack;

class MyMinStack{
     Stack<Integer> ms;
     Stack<Integer> as;

     MyMinStack(){
         ms = new Stack<>();
         as = new Stack<>();
     }

     void push(int x){
         if(ms.isEmpty()){
             ms.add(x);
             as.add(x);
             return;
         }
         ms.add(x);
         if(as.peek()>=ms.peek())
             as.add(x);
     }

     void pop(){
         if(Objects.equals(as.peek(), ms.peek()))
             as.pop();
         ms.pop();
     }

     int top(){
         return ms.peek();
     }

     int getMin(){
         return as.peek();
     }
}
public class Stack_GetMinInStack {
    public static void main(String[] args){
        MyMinStack m = new MyMinStack();
        m.push(1);
        m.push(2);
        m.push(3);
        m.pop();
        m.push(5);

        System.out.println("Top of Stack is: "+m.top());
        System.out.println("Minimum element of sheet.stack: "+m.getMin());
    }
}