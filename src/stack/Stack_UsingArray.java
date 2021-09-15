package stack;

class MyStack{
    int[] arr;
    int cap,top;

    MyStack(int c){
        top = -1;
        cap = c;
        arr = new int[c];
    }

    void push(int x){
        top++;
        arr[top]=x;
    }

    int pop(){
        int res = arr[top];
        top--;
        return res;
    }

    int size(){
        return top+1;
    }

    boolean isEmpty(){
        return (top==-1);
    }
}
public class Stack_UsingArray {
    public static void main(String[] args){
        MyStack ms = new MyStack(5);
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        System.out.println(ms.pop());
        ms.push(5);
        System.out.println(ms.size());
        System.out.println(ms.isEmpty());
    }
}