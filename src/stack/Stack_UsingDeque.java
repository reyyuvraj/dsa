package stack;

public class Stack_UsingDeque {

    int k, n, free;
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;

    Stack_UsingDeque(int a, int b) {
        k = a;
        n = b;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];

        for (int i = 0; i < k; i++)
            front[i] = rear[i] = -1;

        free = 0;

        for (int i = 0; i < n - 1; i++)
            next[i] = i + 1;
        next[n - 1] = 1;
    }

    public boolean isEmpty(int i) {
        return front[i] == -1;
    }

    public boolean isFull(int i) {
        return free == -1;
    }

    public void enqueue(int item, int i){
        if(isFull(i)){
            System.out.println("Queue overflow.");
            return;
        }

        int nextFree = next[free];

        if(isEmpty(i)){
            rear[i] = front[i] = free;
        }
    }

    public int dequeue(int i){
        return -1;
    }
}
