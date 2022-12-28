package self.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesMinimizeTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> max =  new PriorityQueue<>(Collections.reverseOrder());
        int totalStones=0;
        for(int i: piles){
            totalStones+=i;
            max.add(i);
        }

        int removed=0;
        for(int i=k;i>=0;i--) {
            double a = max.poll();
            double b = a;
            removed = (int) Math.floor(b/2);
            max.add((int)a-removed);
        }

        return totalStones-removed;
    }
}
