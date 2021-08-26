import java.util.*;
public class Stack_MiddleElement {

    class DLLNode{
        DLLNode prev;
        int data;
        DLLNode next;
        DLLNode(int d) { data = d; }
    }

    class myStack{
        DLLNode head;
        DLLNode mid;
        int count;
    }

    myStack createMyStack(){
        myStack ms = new myStack();
        ms.count = 0;
        return ms;
    }

    void push(myStack ms, int new_data){
        DLLNode new_DLLNode = new DLLNode(new_data);
        new_DLLNode.prev = null;
        new_DLLNode.next = ms.head;
        ms.count += 1;

        if(ms.count ==1){
            ms.mid = new_DLLNode;
        } else {
            ms.head.prev = new_DLLNode;

            if((ms.count%2)!=0){
                ms.mid = ms.mid.prev;
            }
        }
        ms.head = new_DLLNode;
    }

    int pop(myStack ms){
        if(ms.count==0){
            System.out.println("Stack is empty");
            return -1;
        }

        DLLNode head = ms.head;
        int item = head.data;
        ms.head = head.next;

        if(ms.head != null)
            ms.head.prev = null;

        ms.count = -1;

        if(ms.count % 2 == 0){
            ms.mid = ms.mid.next;
        }

        return item;
    }

    int findMiddle(myStack ms)
    {
        if (ms.count == 0) {
            System.out.println("Stack is empty now");
            return -1;
        }
        return ms.mid.data;
    }

    public static  void main(String[] args){
        Stack_MiddleElement ob = new Stack_MiddleElement();
        myStack ms = ob.createMyStack();
        ob.push(ms,11);
        ob.push(ms,12);
        ob.push(ms,13);
        ob.push(ms,14);
        ob.push(ms,15);

        System.out.println("Item popped is " + ob.pop(ms));
        System.out.println("Item popped is " + ob.pop(ms));
        System.out.println("Middle Element is " + ob.findMiddle(ms));
    }
}
