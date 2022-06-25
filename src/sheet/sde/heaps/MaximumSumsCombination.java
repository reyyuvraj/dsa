package sheet.sde.heaps;

import java.util.*;

public class MaximumSumsCombination {

    public int[] solve(int[] a, int[] b, int c) {
        int[] res = new int[c];
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : a) {
            for (int j : b) {
                pq.offer(i + j);
            }
        }

        while (count < c) {
            res[count] = pq.peek();
            pq.remove();
            count++;
        }

        return res;
    }

    public int[] solveOptimised(int[] a, int[] b, int c) {
        int len = a.length;
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<PairSum> sums = new PriorityQueue<>();

        HashSet<Pair> pairs = new HashSet<>();

        int l = len - 1;
        int m = len - 1;

        pairs.add(new Pair(l, m));
        sums.add(new PairSum(a[l] + b[m], l, m));

        for (int i=0;i<len;i++){

            PairSum max = sums.poll();
            System.out.println(max.sum);
            l = max.l-1;
            m = max.m;
        }//incomplete

        return new int[]{0};
    }

    public static class Pair {

        public Pair(int l, int m) {
            this.l = l;
            this.m = m;
        }

        int l;
        int m;

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair obj = (Pair) o;
            return (l == obj.l && m == obj.m);
        }

        @Override
        public int hashCode() {
            return Objects.hash(l, m);
        }
    }

    public static class PairSum
            implements Comparable<PairSum> {

        public PairSum(int sum, int l, int m) {
            this.sum = sum;
            this.l = l;
            this.m = m;
        }

        int sum;
        int l;
        int m;

        @Override
        public int compareTo(PairSum o) {
            return Integer.compare(o.sum, sum);
        }
    }
}
