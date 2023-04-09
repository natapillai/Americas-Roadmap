package MSTAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class EulerianCircuit {

    double graph[][];
    double sum=0;
    public EulerianCircuit(List<Edge> vertices,int V)
    {
        graph=new double[V][V];
        int u=0,v=0;double weight=0.0;
        for(Edge e:vertices) {
            u = e.getEdge1();
            v = e.getEdge2();
            weight = e.getWeight();
            graph[v][u]=graph[u][v] = weight;
        }
    }
    public List<Integer> EulerianCircuitAlgorithm()
    {
        List<Integer> circuit = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int numEdges = 0;

        // Count the number of edges and check for invalid degrees
        int[] degrees = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    degrees[i]++;
                    numEdges++;
                }
            }
            if (degrees[i] % 2 == 1) {
                return null;
            }
        }
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = stack.peek();
            boolean found = false;

            for (int i = 0; i < graph[v].length; i++) {
                if (graph[v][i] != 0) {
                    sum+=graph[v][i];
                    graph[v][i] = 0;
                    graph[i][v] = 0;
                    stack.push(i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                circuit.add(stack.pop());
            }
        }
        Collections.reverse(circuit);
        return circuit;
    }

    public double getCost()
    {
        return sum;
    }
}
