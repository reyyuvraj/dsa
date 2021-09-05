import java.util.Stack;

class MyMinOneStack{
     Stack<Integer> s;
     int min;

     MyMinOneStack(){
         s = new Stack<>();
     }

     void push(int x){
         if(s.isEmpty()){
             min = x;
             s.add(x);
         } else if(x<=min){
             s.add(2*x-min);
         } else {
             s.add(x);
         }
     }

     int pop(){
         int t = s.peek();
         s.pop();
         if(t<=min){
             int res=min;
             min=2*min-t;
             return res;
         }else{
             return t;
         }
     }

     int peek(){
         int t=s.peek();
         return (Math.max(t, min));
     }

     int getMin(){
         return min;
     }
}
public class Stack_GetMinInStackInOOne {
    public static void main(String[] args){
        MyMinOneStack ms = new MyMinOneStack();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        System.out.println("Item popped from the stack : "+ms.pop());
        ms.push(4);
        System.out.println("Top of the stack : "+ms.peek());
        System.out.println("Minimum of the stack : "+ms.getMin());
    }
}
