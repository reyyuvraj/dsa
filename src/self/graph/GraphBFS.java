package self.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// for a connected undirected graph
public class GraphBFS {

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
        System.out.println(Arrays.toString(bfs(gr, v, 3).toArray()));
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> gr, int u, int v) {
        gr.get(u).add(v);
        gr.get(v).add(u);
    }

    private static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> gr, int v, int s) {
        boolean[] visited = new boolean[v + 1];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> a = new ArrayList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            a.add(u);
            for (int i : gr.get(u)) {
                if (visited[i] == false) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return a;
    }
}
