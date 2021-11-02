package self.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFSDisconnected {

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> gr = new ArrayList<>(v);

        for (int i = 0; i < v; i++)
            gr.add(new ArrayList<>());

        addEdge(gr, 0, 1);
        addEdge(gr, 1, 0);
        addEdge(gr, 1, 2);
        addEdge(gr, 1, 3);
        addEdge(gr, 2, 3);
        addEdge(gr, 4, 0);
        bfsDisconnected(gr, 5);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> gr, int u, int v) {
        gr.get(u).add(v);
        gr.get(v).add(u);
    }

    private static void bfsDisconnected(ArrayList<ArrayList<Integer>> gr, int v) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i])
                bfs(gr, i, visited);
        }
    }

    private static void bfs(ArrayList<ArrayList<Integer>> gr, int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int i : gr.get(u)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

}
