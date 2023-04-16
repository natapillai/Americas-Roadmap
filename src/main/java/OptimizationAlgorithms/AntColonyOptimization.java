package OptimizationAlgorithms;

import java.util.ArrayList;
import java.util.Random;

public class AntColonyOptimization
{
    private double[][] pheromone;
    private int numAnts;
    private int numIterations;
    private double alpha;
    private double beta;
    private double evaporation;
    private double Q;
    private double[][] distance;
    private int numCities;
    private ArrayList<Integer> bestTour;
    private double bestTourlength;

    public int getNumCities()
    {
        return numCities;
    }

    public AntColonyOptimization(double[][] pheromone, int numAnts, int numIterations, double alpha, double beta,
                                 double evaporation, double q, double[][] distance, int numCities) {
        this.distance = distance;
        this.numAnts = numAnts;
        this.numIterations = numIterations;
        this.alpha = alpha;
        this.beta = beta;
        this.evaporation = evaporation;
        this.Q = q;
        this.numCities = distance.length;
        this.pheromone = new double[numCities][numCities];
        this.bestTour = new ArrayList<>();
        this.bestTourlength = Double.MAX_VALUE;
    }

    private void updatePheromonetrails(Ant[] ants)
    {
        evaporatePheromonetrails();
        for(Ant ant: ants) {
            double pheromone_deposit = Q / ant.getTourLength();
            for (int i = 0; i < numCities - 1; i++) {
                int city1 = ant.getTour().get(i);
                int city2 = ant.getTour().get(i + 1);
                pheromone[city1][city2] += pheromone_deposit;
                pheromone[city2][city1] += pheromone_deposit;
            }

            int firstcity = ant.getTour().get(0);
            int lastcity = ant.getTour().get(numCities - 1);
            pheromone[firstcity][lastcity] += pheromone_deposit;
            pheromone[lastcity][firstcity] += pheromone_deposit;
        }
    }

    private void evaporatePheromonetrails()
    {
        for(int i = 0; i< numCities; i++)
        {
            for(int j = 0; j<numCities; j++)
            {
                pheromone[i][j] *= (1 - evaporation);
            }
        }
    }

    public void solve()
    {
        Random rand = new Random();

        for(int i=0; i< numIterations; i++) {
            Ant[] ants = new Ant[numAnts];
            for (int j = 0; j < numAnts; j++) {
                ants[j] = new Ant(rand.nextInt(numCities), numCities);
            }
            for (int j = 0; j < numCities - 1; j++) {
                for (Ant ant : ants) {
                    ant.chooseNextCity(pheromone, distance, alpha, beta);
                }
            }

            updatePheromonetrails(ants);

            for (Ant ant : ants) {
                if (ant.getTourLength() < bestTourlength) {
                    bestTourlength = ant.getTourLength();
                    bestTour = ant.getTour();
                }
            }

            evaporatePheromonetrails();
        }
    }

    public ArrayList<Integer> getBestTour() {
        return bestTour;
    }

    public double[][] getDistance() {
        return distance;
    }

    public double[][] getPheromone() {
        return pheromone;
    }

    public double getBestTourlength() {
        return bestTourlength;
    }
}
