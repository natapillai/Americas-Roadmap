package Utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CostTraversalTest
{
    @Test
    public void test1(){

        List<Integer> hamiltonianCiricuit= new ArrayList<>();
        hamiltonianCiricuit.add(0);
        hamiltonianCiricuit.add(1);
        hamiltonianCiricuit.add(3);
        hamiltonianCiricuit.add(2);

        double graph[][] = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        CostTraversal costTraversal=new CostTraversal();
        double cost = costTraversal.costTraversal(hamiltonianCiricuit, 4, graph, 0);

        assertEquals(80.0,cost,0.10);
    }

    @Test
    public void test2(){

        List<Integer> hamiltonianCiricuit= new ArrayList<>();
        hamiltonianCiricuit.add(0);
        hamiltonianCiricuit.add(1);
        hamiltonianCiricuit.add(3);
        hamiltonianCiricuit.add(2);
        hamiltonianCiricuit.add(0);

        double graph[][] = {{0, 5, 8, 999},
                {5, 0, 10, 15},
                {8, 10, 0, 20},
                {999, 15, 20, 0}};

        CostTraversal costTraversal=new CostTraversal();
        double cost = costTraversal.costTraversal(hamiltonianCiricuit, 4, graph, 0);

        assertEquals(48.0,cost,0.10);
    }

    @Test
    public void test3(){

        List<Integer> hamiltonianCiricuit= new ArrayList<>();
        hamiltonianCiricuit.add(1);
        hamiltonianCiricuit.add(0);
        hamiltonianCiricuit.add(2);
        hamiltonianCiricuit.add(3);
        hamiltonianCiricuit.add(1);

        double graph[][] = {{0, 5, 8, 999},
                {5, 0, 10, 15},
                {8, 10, 0, 20},
                {999, 15, 20, 0}};

        CostTraversal costTraversal=new CostTraversal();
        double cost = costTraversal.costTraversal(hamiltonianCiricuit, 4, graph, 1);

        assertEquals(48,cost,0.10);
    }
}
