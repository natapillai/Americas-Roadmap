package OptimizationAlgorithms;

import Utils.CostTraversal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulatedAnnealing {

    public List<Integer> simulatedAnnealing(List<Integer> tour, double graph[][],int iterations)
    {
        List<Integer> currentSolution = new ArrayList<>(tour);

        CostTraversal costTraversal=new CostTraversal();
        double currentTourLength = costTraversal.costTraversal(currentSolution,graph.length,graph,tour.get(0));

        ArrayList<Integer> bestSolution = new ArrayList<>(currentSolution);
        double bestTourLength = currentTourLength;

        for(int y=0;y<iterations;y++){

            int numEdges= graph.length;
            double temperature = 999999999;
            double coolingRate=0.9999999;

            while (temperature > 0.1)
            {
                ArrayList<Integer> newSolution = new ArrayList<>(currentSolution);

                int vertex1 = 0;
                int vertex2 = 0;

                Random random = new Random();
                while (vertex1 == vertex2)
                {
                    vertex1 = random.nextInt(numEdges);
                    vertex2 = random.nextInt(numEdges);
                }

                int temp = newSolution.get(vertex1);
                newSolution.set(vertex1, newSolution.get(vertex2));
                newSolution.set(vertex2, temp);

                double newTourLength = costTraversal.costTraversal(newSolution,graph.length,graph,newSolution.get(0));;

                double delta = newTourLength - currentTourLength;

                if (delta < 0 || Math.exp(-delta / temperature) > random.nextDouble()) {
                    currentSolution = new ArrayList<>(newSolution);
                    currentTourLength = newTourLength;
                }

                if (currentTourLength < bestTourLength) {
                    bestSolution = new ArrayList<>(currentSolution);
                    bestTourLength = currentTourLength;
                }

                temperature *= coolingRate;
            }

        }


        return bestSolution;
    }
}
