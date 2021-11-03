package self.graph;

import java.util.ArrayList;

public class DFSDisconnected {

    void dfs(ArrayList<ArrayList<Integer>> gr, int v) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++)
            if (!visited[i])
                dfsDisconnected(gr, i, visited);
    }

    private void dfsDisconnected(ArrayList<ArrayList<Integer>> gr, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int i : gr.get(s))
            if (!visited[i])
                dfsDisconnected(gr, i, visited);
    }
}
