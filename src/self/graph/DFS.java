package self.graph;

import java.util.ArrayList;

public class DFS {

    void dfsSearch(ArrayList<ArrayList<Integer>> gr, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int i : gr.get(s))
            if (!visited[i])
                dfsSearch(gr, i, visited);
    }

    void dfs(ArrayList<ArrayList<Integer>> gr, int v, int s) {
        boolean[] visited = new boolean[v];
        dfsSearch(gr, s, visited);
    }
}
