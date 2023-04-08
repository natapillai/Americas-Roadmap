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

    public int getId(int v, int w) {
        if (v == from && w == to) {
            return 0;
        } else if (v == to && w == from) {
            return 0;
        } else {
            throw new IllegalArgumentException("Invalid edge endpoints");
        }
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
