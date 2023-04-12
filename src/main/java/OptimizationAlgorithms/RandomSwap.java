package OptimizationAlgorithms;

import MSTAlgorithms.Hungarian;
import Utils.CostTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomSwap {

    public List<Integer> RandomSwapOpt(List<Integer> a, double graph[][], int numberSwaps)
    {

        int min=graph.length/2,max= graph.length-1;

        CostTraversal costTraversal=new CostTraversal();
        double costBefore=costTraversal.costTraversal(a,graph.length,graph,0);

        List<Integer> newTour=new ArrayList<>(a);
        List<Integer> finalTour=new ArrayList<>(a);
        int count=0;

        for(int i=0;i<numberSwaps;i++)
        {
            int vertex1=(int)Math.floor(Math.random() * (max - min + 1) + min);
            int vertex2=(int)Math.floor(Math.random() * (max - min + 1) + min);

            while(vertex2==vertex1)
                vertex2=(int)Math.floor(Math.random() * (max - min + 1) + min);

            int temp=newTour.get(vertex1);
            newTour.set(vertex1,newTour.get(vertex2));
            newTour.set(vertex2,temp);

            double costAfter=costTraversal.costTraversal(newTour,graph.length,graph,0);
            if(costAfter<costBefore)
                finalTour=new ArrayList<>(newTour);


        }

        return finalTour;
    }
}
