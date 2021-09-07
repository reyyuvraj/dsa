class UsingNode{

    int key;
    UsingNode next;

    public UsingNode(int key){
        this.key = key;
        this.next = null;
    }
}

class Queue
{
    UsingNode front,rear;//references

    Queue()
    {
        this.front = this.rear = null;
    }

    void enqueue(int x)
    {
        UsingNode temp = new UsingNode(x);

        if (this.rear == null)
        {
            this.rear = this.front = temp;
            return;
        }

        this.rear.next = temp;
        this.rear = temp;
    }

    void dequeue()
    {
        if(this.front == null)
            return;

        UsingNode temp = this.front;
        this.front = this.front.next;

        if (this.front == null)
            this.rear = null;
    }
}

public class Queue_UsingLinkedList {
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.dequeue();
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.dequeue();

        System.out.println("Queue front : "+q.front.key);
        System.out.println("Queue rear : "+q.rear.key);
    }
}
