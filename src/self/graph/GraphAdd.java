package self.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphAdd {

    static void addEdge(ArrayList<ArrayList<Integer>> gr, int u, int v) {
        gr.get(u).add(v);
        gr.get(v).add(u);
    }//for an undirected graph

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> gr = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            gr.add(new ArrayList<>());

        addEdge(gr, 0, 1);
        addEdge(gr, 0, 2);
        addEdge(gr, 1, 2);
        addEdge(gr, 1, 3);
        addEdge(gr, 2, 3);
        addEdge(gr, 4, 0);
        System.out.println(Arrays.deepToString(gr.toArray()));
    }
}