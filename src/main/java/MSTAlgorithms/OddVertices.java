package MSTAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class OddVertices {

    public List<Integer> OddVertex(List<Edge> mst, int V)
    {
        List<Integer> oddvertices = new ArrayList<>();
        int degree[]=new int[V];

        for(Edge edge:mst)
        {
            degree[edge.getEdge1()]++;
            degree[edge.getEdge2()]++;
        }

        for(int i=0;i<V;i++)
            if(degree[i]%2==1)
                oddvertices.add(i);

        return oddvertices;
    }

    public double[][] oddVertexCostMatrix(List<Integer> oddvertices,double graph[][])
    {
        double oddMatrix[][]=new double[oddvertices.size()][oddvertices.size()];
        for(int i=0;i<oddvertices.size();i++)
        {
            for(int j=i+1;j<oddvertices.size();j++) {
                int u = oddvertices.get(i);
                int v = oddvertices.get(j);
                oddMatrix[i][j] = oddMatrix[j][i] = graph[u][v];
            }
        }

        return oddMatrix;
    }

}
