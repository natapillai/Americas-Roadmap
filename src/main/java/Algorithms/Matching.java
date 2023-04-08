    package Algorithms;

    import java.util.*;

    public class Matching {
        private static int size()
        {
            return 0;
        }
        public static List<Edge> minimumWeightPerfectMatching(List<Edge> edges)
        {
            List<Edge> matching = new ArrayList<>();

            int numVertices = 0;
            for(Edge edge: edges)
            {
                numVertices = Math.max(numVertices, Math.max(numVertices, Math.max(edge.getFrom(),edge.getTo())));
            }

            double[] label = new double[numVertices + 1];
            int[] mate = new int[numVertices + 1];

            while(matching.size() * 2 < numVertices)
            {
                Arrays.fill(mate, -1);
                Arrays.fill(label, Double.POSITIVE_INFINITY);

                boolean[] inQueue = new boolean[numVertices + 1];
                Queue<Integer> queue = new LinkedList<>();
                for(Edge edge:edges)
                {
                    if(mate[edge.getFrom()] == -1)
                    {
                        label[edge.getFrom()] = 0.0;
                        queue.offer(edge.getFrom());
                        inQueue[edge.getFrom()] = true;
                    }
                    if(mate[edge.getTo()] == -1)
                    {
                        label[edge.getTo()] = 0.0;
                        queue.offer(edge.getTo());
                        inQueue[edge.getTo()] = true;
                    }
                }

                while(!queue.isEmpty())
                {
                    int u = queue.poll();
                    inQueue[u] = false;
                    for(Edge edge:edges)
                    {
                        if(edge.getFrom() == u || edge.getTo() == u)
                        {
                            int v = edge.other(u);
                            double w = edge.getWeight() - label[edge.getFrom()] - label[edge.getTo()];
                            if(w < label[v])
                            {
                                label[v] = w;
                                mate[v] = edge.other(v);
                                if(!inQueue[v])
                                {
                                    queue.offer(v);
                                    inQueue[v] = true;
                                }
                            }
                        }
                    }
                }

                if(matching.size() * 2 == numVertices)
                {
                    break;
                }

                int[] path = new int[numVertices + 1];
                Arrays.fill(path, -1);
                int root = -1;
                for(Edge edge:edges)
                {
                    if(mate[edge.getFrom()] == -1 && label[edge.getFrom()] == 0.0)
                    {
                        root = edge.getFrom();
                        break;
                    }
                    if(mate[edge.getTo()] == -1 && label[edge.getTo()] == 0.0)
                    {
                        root = edge.getTo();
                        break;
                    }
                }
                if(root != -1)
                {
                    Queue<Integer> bfsQueue = new LinkedList<>();
                    bfsQueue.offer(root);
                    path[root] = root;
                    while(!bfsQueue.isEmpty())
                    {
                        int u = bfsQueue.poll();
                        for(Edge edge:edges)
                        {
                            if((edge.getTo() == u && path[edge.getFrom()] == -1 )
                               || (edge.getFrom() == u && path[edge.getTo()] == -1) )
                            {
                                int v = edge.other(u);
                                if(path[v] == -1)
                                {
                                    path[v] = u;
                                    if(mate[v] == -1)
                                    {
                                        int curr = v;
                                        while(curr != root)
                                        {
                                            int next = path[curr];
                                            if(curr != edge.getFrom() && curr != edge.getTo() )
                                            {
                                                matching.add(new Edge(next, curr, edges.get(edge.getId(next, curr)).getWeight()));
                                            }
                                            curr = next;
                                        }
                                        matching.add(edge);
                                        break;
                                    }
                                    else
                                    {
                                        bfsQueue.offer(mate[v]);
                                        path[mate[v]] = v;
                                    }
                                }
                            }
                        }
                    }
                }


            }

            return matching;

        }



    }
