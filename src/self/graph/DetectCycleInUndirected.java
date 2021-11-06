package self.graph;

import java.util.ArrayList;

public class DetectCycleInUndirected {

    boolean cycleUndirected(ArrayList<ArrayList<Integer>> gr, int s, boolean[] visited, int parent) {
        visited[s] = true;

        for (int i : gr.get(s)) {
            if (!visited[i]) {
                if (cycleUndirected(gr, i, visited, s))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }

}
