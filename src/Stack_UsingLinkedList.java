class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}
class MyStackLL
{
    Node head;
    int size;
    MyStackLL()
    {
        head=null;
        size=0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return (head==null);
    }

    void push(int x){
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size++;
    }

    int pop(){
        if(head==null)
            return Integer.MAX_VALUE;
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }

    int peek(){
        if(head==null)
            return Integer.MAX_VALUE;
        return head.data;
    }
}
public class Stack_UsingLinkedList {
    public static void main(String[] args){
        MyStackLL s = new MyStackLL();
        System.out.println(s.isEmpty());
        s.push(1);
        System.out.println(s.peek());
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.isEmpty());
    }
}
