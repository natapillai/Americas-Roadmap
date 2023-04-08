package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;
    private final List<Edge>[] adj;
    public Graph(int V)
    {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0; i<V; i++)
        {
            adj[i] = new ArrayList<>();
        }
    }

    public Graph(int V, List<Edge> edges)
    {
        this(V);
        for(Edge edge : edges)
        {
            addEdge(edge);
        }
    }

    public int degree(int vertex)
    {
        int degree = 0;
        for(Edge edge: adj[vertex])
        {
            degree++;
        }
        return degree;
    }

    public int getV() {
        return V;
    }

    public void addEdge(Edge edge)
    {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
    }

    public void removeEdge(int u, int v)
    {
        adj[u].remove(Integer.valueOf(v));
        adj[v].remove(Integer.valueOf(u));
    }

    public Iterable<Edge> adj(int v)
    {
     return adj[v];
    }

    public Iterable<Edge> edges() {
        List<Edge> list = new ArrayList<>();
        for (int v = 0; v < V; v++)
        {
            for(Edge edge: adj[v])
            {
                if(edge.other(v) > v)
                {
                    list.add(edge);
                }
            }
        }
        return list;
    }
}
