package Utils;

public class AntColonyData {
    private double[][] pheromone;
    private int numAnts;
    private final int numIterations = 1;
    private final double alpha = 1;
    private final double beta  = 5;
    private final double evaporation = 0.5;
    private final double Q = 500;

    public AntColonyData(double[][] graph)
    {
        pheromone = new double[graph.length][graph.length];
        numAnts = graph.length / 2;
    }

    public void initialize_pheromone()
    {
        for(int i = 0; i < pheromone.length; i++)
        {
            for(int j = 0; j < pheromone[i].length; j++)
            {
                pheromone[i][j] = 1.0;
            }
        }
    }

    public double[][] getPheromone()
    {
        return pheromone;
    }

    public int getNumAnts()
    {
        return numAnts;
    }

    public int getNumIterations()
    {
        return numIterations;
    }

    public double getAlpha()
    {
        return alpha;
    }

    public double getBeta()
    {
        return beta;
    }

    public double getEvaporation()
    {
        return evaporation;
    }

    public double getQ()
    {
        return Q;
    }
}
