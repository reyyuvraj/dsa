package self.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    private static int weight(int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//(a,b)->b-a=used for reverse

        for (int i=0;i<n;i++)
            pq.offer(arr[i]);

        while (pq.size()>1){
            pq.offer(pq.poll()- pq.poll());
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        int[] arr = {12,3,8,4,5,9,3,5,7};
        System.out.println(weight(arr, arr.length));
    }
}
