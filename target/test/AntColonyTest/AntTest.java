package AntColonyTest;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import OptimizationAlgorithms.Ant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AntTest {

    @org.junit.jupiter.api.Test
    public void testChooseNextCity()
    {
        Ant ant = new Ant(0, 5);

        double[][] pheromone = {{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}};
        double[][] distance = {{0, 2, 2, 2, 2}, {2, 0, 2, 2, 2}, {2, 2, 0, 2, 2}, {2, 2, 2, 0, 2}, {2, 2, 2, 2, 0}};

        double alpha = 1.0;
        double beta  = 2.0;

        ant.chooseNextCity(pheromone, distance, alpha, beta);

        int nextcity = ant.getTour().get(1);
        assertTrue(nextcity >= 0 && nextcity <= 4);
        assertTrue(ant.getVisited()[nextcity]);
    }

    @org.junit.jupiter.api.Test
    public void testCalculateProbabilities()
    {
        Ant ant = new Ant(0, 5);

        double [][] pheromone = {{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}};
        double [][] distance  = {{0, 2, 2, 2, 2}, {2, 0, 2, 2, 2}, {2, 2, 0, 2, 2}, {2, 2, 2, 0, 2}, {2, 2, 2, 2, 0}};

        double alpha = 1.0;
        double beta  = 2.0;

        double[] probabilities = ant.calculateProbabilities(pheromone, distance, alpha, beta);

        assertEquals(5, probabilities.length);
        for(int i = 0; i<probabilities.length; i++)
        {
            assertTrue(probabilities[i] >= 0 && probabilities[i] <=1);
        }
    }

    @org.junit.jupiter.api.Test
    public void testSelectNextCity()
    {
        Ant ant = new Ant(0, 5);
        double[] probabilities = {0.1, 0.2, 0.3, 0.2, 0.2};

        int nextCity = ant.selectnextCity(probabilities);

        assertTrue(nextCity >= 0 && nextCity <= 4);
        assertFalse(ant.getVisited()[nextCity]);
    }

    @Test
    public void testMove()
    {
        int startcity = 0;
        int numCities = 4;
        double[][] distance = {{0, 1, 2, 3},
                {1, 0, 4, 5},
                {2, 4, 0, 6},
                {3, 5, 6, 0}};
        Ant ant = new Ant(startcity, numCities);
        ant.move(1, distance);
        assertEquals(2, ant.getTour().size());
        assertTrue(ant.getVisited()[1]);
        assertEquals(1.0, ant.getTourLength(), 0.001);

        ant.move(2, distance);
        assertEquals(3, ant.getTour().size());
        assertTrue(ant.getVisited()[2]);
        assertEquals(5.0, ant.getTourLength(), 0.001);

        ant.move(3, distance);
        assertEquals(4, ant.getTour().size());
        assertTrue(ant.getVisited()[3]);
        assertEquals(11.0, ant.getTourLength(), 0.001);

        ant.move(0, distance);
        assertEquals(5, ant.getTour().size());
        assertTrue(ant.getVisited()[0]);
        assertEquals(20.0, ant.getTourLength(), 0.001);

        ant.move(1, distance);
        assertEquals(6, ant.getTour().size());
        assertTrue(ant.getVisited()[1]);
        assertEquals(26.0, ant.getTourLength(), 0.001);

        ant.move(2, distance);
        assertEquals(7, ant.getTour().size());
        assertTrue(ant.getVisited()[2]);
        assertEquals(32.0, ant.getTourLength(), 0.001);

        ant.move(3, distance);
        assertEquals(8, ant.getTour().size());
        assertTrue(ant.getVisited()[3]);
        assertEquals(38.0, ant.getTourLength(), 0.001);

        ant.move(0, distance);
        assertEquals(9, ant.getTour().size());
        assertTrue(ant.getVisited()[0]);
        assertEquals(50.0, ant.getTourLength(), 0.001);
    }
}
