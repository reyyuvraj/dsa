package self.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestUnweighted {


    int[] shortestUnweighted(ArrayList<ArrayList<Integer>> gr, int v, int s, int[] distance) {
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        visited[s]=true;
        q.add(s);
        while (!q.isEmpty()){
            int u = q.poll();

            for (int i: gr.get(u)){
                if (!visited[i]){
                    distance[i]=distance[u]+1;
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
        return distance;
    }
}
