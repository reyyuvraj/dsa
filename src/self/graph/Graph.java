package self.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private static void addEdge(ArrayList<ArrayList<Integer>> gr, int u, int v) {
        gr.get(u).add(v);
        gr.get(v).add(u);
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> gr = new ArrayList<>(v);

        for (int i = 0; i < v; i++)
            gr.add(new ArrayList<>());

        DFS dfs = new DFS();
        DFSDisconnected dfsD = new DFSDisconnected();
        DFSCount dfsC = new DFSCount();
        ShortestUnweighted su = new ShortestUnweighted();

        addEdge(gr,0,1);
        addEdge(gr,1,2);
        addEdge(gr,2,3);
        addEdge(gr,0,2);
        addEdge(gr,1,3);
        System.out.println();
        dfs.dfs(gr, 5, 0);
        System.out.println();
        dfsD.dfs(gr,5);
        System.out.println();
        System.out.println(dfsC.dfs(gr, 5));
        int[] distance =  new int[4];
        System.out.println(Arrays.toString(su.shortestUnweighted(gr, 4, 0, distance)));
    }
}
