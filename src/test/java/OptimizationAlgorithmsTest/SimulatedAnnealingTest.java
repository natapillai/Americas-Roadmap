package OptimizationAlgorithmsTest;

import MSTAlgorithms.Edge;
import MSTAlgorithms.Prims;
import OptimizationAlgorithms.SimulatedAnnealing;
import OptimizationAlgorithms.TwoOpt;
import Utils.CostTraversal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimulatedAnnealingTest
{
    @Test
    public void test1(){

        List<Integer> tour=new ArrayList<>();
        tour.add(0);
        tour.add(1);
        tour.add(3);
        tour.add(2);
        tour.add(0);

        double graph[][] = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        SimulatedAnnealing simulatedAnnealing=new SimulatedAnnealing();
        tour=simulatedAnnealing.simulatedAnnealing(tour,graph,1);

        Prims prims=new Prims();
        List<Edge> mst=prims.PrimsAlgorithms(graph);

        double costmst=0.0;
        for(int i=0;i<mst.size();i++)
            costmst+=mst.get(i).getWeight();

        CostTraversal costTraversal=new CostTraversal();
        double cost=costTraversal.costTraversal(tour, graph.length, graph, 0);

        assertEquals(costmst,cost,(costmst*1.20));
    }

    @Test
    public void test2(){

        List<Integer> tour=new ArrayList<>();
        tour.add(1);
        tour.add(0);
        tour.add(2);
        tour.add(3);
        tour.add(1);

        double graph[][] = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        SimulatedAnnealing simulatedAnnealing=new SimulatedAnnealing();
        tour=simulatedAnnealing.simulatedAnnealing(tour,graph,1);

        Prims prims=new Prims();
        List<Edge> mst=prims.PrimsAlgorithms(graph);

        double costmst=0.0;
        for(int i=0;i<mst.size();i++)
            costmst+=mst.get(i).getWeight();

        CostTraversal costTraversal=new CostTraversal();
        double cost=costTraversal.costTraversal(tour, graph.length, graph, 1);

        assertEquals(costmst,cost,(costmst*1.20));
    }

    @Test
    public void test3(){

        List<Integer> tour=new ArrayList<>();
        tour.add(1);
        tour.add(0);
        tour.add(2);
        tour.add(3);
        tour.add(1);

        double graph[][] = {{0, 5, 8, 999},
                {5, 0, 10, 15},
                {8, 10, 0, 20},
                {999, 15, 20, 0}};

        SimulatedAnnealing simulatedAnnealing=new SimulatedAnnealing();
        tour=simulatedAnnealing.simulatedAnnealing(tour,graph,1);

        Prims prims=new Prims();
        List<Edge> mst=prims.PrimsAlgorithms(graph);

        double costmst=0.0;
        for(int i=0;i<mst.size();i++)
            costmst+=mst.get(i).getWeight();

        CostTraversal costTraversal=new CostTraversal();
        double cost=costTraversal.costTraversal(tour, graph.length, graph, 1);

        assertEquals(costmst,cost,(costmst*1.20));
    }
}
