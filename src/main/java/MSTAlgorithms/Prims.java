package MSTAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims
{
    public List<Edge> PrimsAlgorithms(double graph[][])
    {
        int V=graph.length;

        boolean visited[]=new boolean[V];

        PriorityQueue<Edge> minedge = new PriorityQueue<>((edge1,edge2)-> (int) (edge1.getWeight()-edge2.getWeight()));

        List<Edge> mst=new ArrayList<>();

        visited[0]=true;

        for(int i=1;i<V;i++)
            if (graph[0][i] != 0)
                minedge.add(new Edge(0,i,graph[0][i]));

        while(!minedge.isEmpty() && mst.size()<V-1)
        {
            Edge edge = minedge.poll();
            int u = edge.getEdge1();
            int v = edge.getEdge2();

            if(!visited[v] || ! visited[u])
            {
                visited[v]=true;
                visited[u]=true;

                mst.add(edge);

                int vertex[]=!visited[u] ? new int[]{u, v} : new int[]{v, u};
                for(int i=0;i<vertex.length;i++)
                {
                    int ve=vertex[i];
                    for(int j=0;j<V;j++)
                        if (graph[ve][j] != 0 && !visited[j])
                        {
                            minedge.add(new Edge(ve, j, graph[ve][j]));
                        }
                }
            }
        }
        return mst;
    }
}
