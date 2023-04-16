package AntColonyTest;

import OptimizationAlgorithms.Ant;
import OptimizationAlgorithms.AntColonyOptimization;
import Utils.AntColonyData;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class AntColonyOptimizationTest {

    double[][] pheromone;
    double[][] distance;


    AntColonyOptimization aco;
    @BeforeEach
    public void initialize_data()
    {
        distance = new double[][]{{0, 2, 3}, {2, 0, 4}, {3, 4, 0}};
        AntColonyData acd = new AntColonyData(distance);
        acd.initialize_pheromone();
        pheromone = acd.getPheromone();
        aco = new AntColonyOptimization(acd.getPheromone(), acd.getNumAnts(), acd.getNumIterations(), acd.getAlpha(), acd.getBeta(), acd.getEvaporation(), acd.getQ(), distance, 3);
    }

    @Test
    public void testSolve() {

        aco.solve();
        ArrayList<Integer> bestTour = aco.getBestTour();
        assertEquals(4, bestTour.size());
        assertTrue(bestTour.contains(0));
        assertTrue(bestTour.contains(1));
        assertTrue(bestTour.contains(2));
        assertTrue(bestTour.contains(0));
    }

}
