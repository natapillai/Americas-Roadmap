package OptimizationAlgorithmsTest;

import OptimizationAlgorithms.Ant;
import OptimizationAlgorithms.AntColonyOptimization;
import Utils.AntColonyData;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AntColonyOptimizationTest {
    private double[][] pheromone;
    private double[][] distance;
    private AntColonyOptimization aco;
    private int numAnts;
    private int numIterations;
    private double alpha;
    private double beta;
    private double evaporation;
    private double Q;
    private int numCities;

    @Before
    public void setup()
    {
        numCities = 5;
        distance = new double[][]{ { 0, 1, 2, 3, 4 }, { 1, 0, 1, 2, 3 }, { 2, 1, 0, 1, 2 }, { 3, 2, 1, 0, 1 },
                { 4, 3, 2, 1, 0 } };
        pheromone = new double[numCities][numCities];
        numAnts = 10;
        numIterations = 5;
        alpha = 1.0;
        beta = 5.0;
        evaporation = 0.5;
        Q = 100.0;
        aco = new AntColonyOptimization(pheromone, numAnts, numIterations, alpha, beta, evaporation, Q, distance, numCities);
    }

    @Test
    public void testgetNumCities()
    {
        assertEquals(numCities, aco.getNumCities());
    }

    @Test
    public void testSolve()
    {
        aco.solve();
        List<Integer> bestTour = aco.getBestTour();
        double bestTourLength = aco.getBestTourlength();
        int size = numCities + 1;

        assertEquals(size, bestTour.size());
        for(int i = 0; i < numCities; i++)
        {
            assertTrue(bestTour.contains(i));
        }

        double expected_length = 8.0;
        assertTrue(bestTourLength > 0.0);
        assertTrue(bestTourLength < Double.MAX_VALUE);
        assertEquals(expected_length, bestTourLength, 0.0);
    }


}
