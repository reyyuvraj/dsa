public class Queue_UsingArray {

    int front, rear, size, capacity;
    int[] arr;

    public Queue_UsingArray(int capacity) {
        this.capacity = capacity;
        front = size = 0;
        rear = capacity = -1;
        arr = new int[this.capacity];
    }

    boolean isFull(Queue_UsingArray queue) {
        return (queue.size == queue.capacity);
    }

    boolean isEmpty(Queue_UsingArray queue) {
        return (queue.size == 0);
    }

    void enqueue(int item) {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.arr[rear] = item;
        size = size + 1;
        System.out.println(item + " enqueued to queue");
    }

    int dequeue() {
        if (isEmpty(this))
            return Integer.MAX_VALUE;

        int item = arr[front];
        front = (front + 1) % capacity;
        size = size - 1;
        return item;
    }

    int front() {
        if (isEmpty(this))
            return Integer.MAX_VALUE;
        return arr[front];
    }

    int rear() {
        if (isEmpty(this))
            return Integer.MAX_VALUE;
        return arr[rear];
    }

    public static void main(String[] args) {
        Queue_UsingArray qs = new Queue_UsingArray(5);
        qs.enqueue(1);
        qs.enqueue(2);
        qs.enqueue(3);
        qs.enqueue(4);

        System.out.println(qs.dequeue() + " dequeued from the stack");

        System.out.println("Front item is " + qs.front());

        System.out.println("Rear item is " + qs.rear());

    }
}
