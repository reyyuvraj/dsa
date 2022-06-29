package self.leetcode;

import java.util.*;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueueNotWorking(int[][] people) {
        HashMap<Integer, PriorityQueue<Integer>> height = new HashMap<>();
        Integer[] heights = new Integer[people.length];

        for (int i = 0; i < people.length; i++)
            heights[i] = people[i][0];
        Arrays.sort(heights, Collections.reverseOrder());

        for (int[] person : people) {
            if (!height.containsKey(person[0]))
                height.put(person[0], new PriorityQueue<>());
            height.get(person[0]).add(person[1]);
        }

        System.out.println(height);
        System.out.println(Arrays.toString(heights));

        ArrayList<int[]> res = new ArrayList<>();

        return res.toArray(new int[people.length][2]);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.toString(new QueueReconstructionByHeight().reconstructQueue(people)));
    }
}
