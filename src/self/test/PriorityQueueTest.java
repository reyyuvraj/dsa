package self.test;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] a){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(1);
        pq.add(20);
        pq.add(10);
        pq.add(30);
        System.out.println(pq);

        while (!pq.isEmpty())
            System.out.print(pq.poll()+" ");
        System.out.println();

        System.out.println(pq+"\n");

        PriorityQueue<Integer> des=new PriorityQueue<>(Collections.reverseOrder());
        des.add(1);
        des.add(20);
        des.add(10);
        des.add(5);
        System.out.println(des);

        while (!des.isEmpty())
            System.out.print(des.poll()+" ");
        System.out.println();

        System.out.println(des);
    }
}
