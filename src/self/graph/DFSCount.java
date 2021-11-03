package self.graph;

import java.util.ArrayList;

public class DFSCount {

    int dfs(ArrayList<ArrayList<Integer>> gr, int v){
        boolean[] visited = new boolean[v];
        int count=0;

        for (int i = 0; i<v;i++)
            if (!visited[i]){
                count++;
                dfsDisconnected(gr,i,visited);
            }
        return count++;
    }

    private void dfsDisconnected(ArrayList<ArrayList<Integer>> gr, int s, boolean[] visited) {
        visited[s]=true;

        for (int i : gr.get(s))
            if (!visited[i])
                dfsDisconnected(gr, i, visited);
    }
}
