package MST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {
    public static List<Edge> findMST(double[][] matrix)
    {
        int n = matrix.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<Edge> mst = new ArrayList<>();

        visited[0] = true;
        for(int i = 0; i < n-1; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    for (int k = 0; k < n; k++) {
                        if (!visited[k]) {
                            pq.offer(new Edge(j, k, matrix[j][k]));
                        }
                    }
                }
            }
            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    mst.add(edge);
                    break;
                }
            }
        }

return mst;
    }

}
