package Utils;

import java.util.List;

public class CostTraversal {

    public double costTraversal(List<Integer> hamcircuit, int V, double graph[][], int source)
    {
        double cost=0;
        int prev=source;
        boolean visited[]=new boolean[V];
        for(int i:hamcircuit)
        {
            if(!visited[i])
            {
                visited[i]=true;
                cost+=graph[prev][i];
                prev=i;
            }
        }
        cost+=graph[prev][source];
        return cost;
    }

}
