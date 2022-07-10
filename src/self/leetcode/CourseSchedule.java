package self.leetcode;

import java.util.ArrayList;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites)
            adj.get(prerequisite[0]).add(prerequisite[1]);

        return isCycle(numCourses, adj);
    }

    private boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i])
                if (checkForCycle(i, -1, vis, adj))
                    return true;
        }

        return false;
    }

    private boolean checkForCycle(int node,
                                  int parent,
                                  boolean[] vis,
                                  ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (checkForCycle(it, node, vis, adj)) {
                    return true;
                }
            } else if (it != parent)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0}, {0, 1}};
        int numCourses = 2;

        System.out.println(new CourseSchedule().canFinish(numCourses, arr));
    }
}
