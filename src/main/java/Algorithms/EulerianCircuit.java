package Algorithms;

import java.util.*;

public class EulerianCircuit {
    public static List<Integer> computeEulerianCircuit(Graph graph)
    {
        if(!isEulerian(graph))
        {
            throw new IllegalArgumentException("Graph does not have an Eulerian circuit");
        }
        Graph g = new Graph(graph.getV());
        List<Integer> circuit = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int current = 0;
        stack.push(current);

        while(!stack.empty())
        {
            if(g.degree(current) == 0)
            {
                circuit.add(current);
                current = stack.pop();
            }
            else
            {
                stack.push(current);
                Edge nextEdge = g.adj(current).iterator().next();
                int next = nextEdge.other(current);
                g.removeEdge(current, next);
                current = next;
            }
        }
        return circuit;
    }

    private static boolean isEulerian(Graph graph) {
        int n = graph.getV();
        for (int i = 0; i < n; i++) {
            if (graph.degree(i) % 2 != 0) {
                return false;
            }
        }
        return true;
    }

}
