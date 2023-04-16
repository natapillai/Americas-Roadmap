package OptimizationAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ant {
    private int currentCity;
    private int startCity;
    private boolean[] visited;
    private ArrayList<Integer> tour;
    private double tourLength;
    private Random rand;
    private int numCities;

    public Ant(int startCity, int numCities)
    {
        this.startCity  = startCity;
        this.currentCity = startCity;
        this.visited = new boolean[numCities];
        Arrays.fill(this.visited, false);
        this.visited[startCity] = true;
        this.tour = new ArrayList<Integer>();
        this.tour.add(startCity);
        this.tourLength = 0;
        this.rand = new Random();
        this.numCities = numCities;
    }

    public void chooseNextCity(double[][] pheromone, double[][] distance, double alpha, double beta)
    {
        double[] probabilites = calculateProbabilities(pheromone, distance, alpha, beta);
        int nextCity = selectnextCity(probabilites);
        move(nextCity, distance);
    }

    public double[] calculateProbabilities(double[][] pheromone, double[][] distance, double alpha, double beta) {
        double[] probabilities = new double[numCities];
        double sum = 0;
        for (int i = 0; i < numCities; i++) {
            if (!visited[i]) {
                probabilities[i] = Math.pow(pheromone[currentCity][i], alpha) * Math.pow(1.0 / distance[currentCity][i], beta);
                sum += probabilities[i];
            }
        }
        for (int i = 0; i < numCities; i++) {
            probabilities[i] /= sum;
        }
        return probabilities;
    }

    public int selectnextCity(double[] probabilities) {
        double randomValue = rand.nextDouble();
        double cumulativeProbability = 0;
        int nextCity = -1;
        for (int i = 0; i < numCities; i++) {
            if (!visited[i]) {
                cumulativeProbability += probabilities[i];
                if (randomValue <= cumulativeProbability) {
                    nextCity = i;
                    break;
                }
            }
        }
        if (nextCity == -1) {
            for (int i = 0; i < numCities; i++) {
                if (!visited[i]) {
                    nextCity = i;
                    break;
                }
            }
        }
        return nextCity;
    }

    public void move(int nextCity, double[][] distance) {
        tour.add(nextCity);
        visited[nextCity] = true;
        tourLength += distance[currentCity][nextCity];
        currentCity = nextCity;
        if(tour.size() == visited.length)
        {
            tourLength += distance[currentCity][startCity];
            tour.add(startCity);
            currentCity = startCity;
        }
    }

    public void setTourLength(double tourLength) {
        this.tourLength = tourLength;
    }

    public double getTourLength() {
        return tourLength;
    }

    public ArrayList<Integer> getTour() {
        return tour;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public void setTour(ArrayList<Integer> tour) {
        this.tour = tour;
    }

    public void reset(int startCity) {
        this.currentCity = startCity;
        Arrays.fill(visited, false);
        visited[startCity] = true;
        tour.clear();
        tour.add(startCity);
        tourLength = 0;
    }
}
