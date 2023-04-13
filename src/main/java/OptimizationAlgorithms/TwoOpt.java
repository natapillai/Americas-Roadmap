package OptimizationAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class TwoOpt {
    public List<Integer> TwoOptAlgorithm(List<Integer> a, double graph[][])
    {

        int tour[]=new int[a.size()];
        for(int i=0;i<a.size();i++)
            tour[i]=a.get(i);


            boolean improvement = true;
            while (improvement) {
                improvement = false;

                for (int i = 0; i < graph.length - 2; i++) {
                    for (int k = i + 2; k < graph.length; k++) {
                        int j = (i + 1) % graph.length;
                        int l = (k + 1) % graph.length;

                        double costBefore = graph[tour[i]][tour[j]] + graph[tour[k]][tour[l]];
                        double costAfter = graph[tour[i]][tour[k]] + graph[tour[j]][tour[l]];

                        if (costAfter < costBefore) {

                            int vertexj = tour[j];
                            int vertexk = tour[k];

                            tour[j] = vertexk;
                            tour[k] = vertexj;

                            improvement = true;
                        }
                    }
                }
            }
        List<Integer> newTour=new ArrayList<>();
        for(int i=0;i<tour.length;i++)
        {
            if(tour[i]==0)
                newTour.add(a.get(i));
            else
                newTour.add(tour[i]);
        }

        return newTour;
    }
}
