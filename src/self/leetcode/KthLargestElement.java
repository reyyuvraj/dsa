package self.leetcode;

import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : arr) {
            pq.offer(val);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.size() > 0 ? pq.peek() : -1;
    }
}
