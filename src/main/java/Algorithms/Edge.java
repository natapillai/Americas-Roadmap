package Algorithms;

public class Edge implements Comparable<Edge> {
    int from;
    int to;
    double weight;

    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    public int either()
    {
        return from;
    }

    public int other(int v)
    {
        if(v == from) return from;
        else if(v == to) return to;
        else throw new RuntimeException("Inconsistent edge");
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }
}
