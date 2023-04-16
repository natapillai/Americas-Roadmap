package AntColonyTest;

import Utils.AntColonyData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AntColonyDataTest {
    @Test
    public void testInitializePheromone()
    {
        double[][] graph = {{0, 1, 2}, {1, 0, 1}, {2, 1, 0}};

        AntColonyData acd = new AntColonyData(graph);
        acd.initialize_pheromone();

        double[][] pheromone = acd.getPheromone();
        for(int i = 0; i < pheromone.length; i++)
        {
            for(int j = 0; j< pheromone[i].length; j++)
            {
                assertEquals(1.0, pheromone[i][j], 0.0);
            }
        }
    }

}
