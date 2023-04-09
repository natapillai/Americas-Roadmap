package MSTAlgorithms;

public class Edge
{
    public int getEdge1() {
        return edge1;
    }

    public void setEdge1(int edge1) {
        this.edge1 = edge1;
    }

    public int getEdge2() {
        return edge2;
    }

    public void setEdge2(int edge2) {
        this.edge2 = edge2;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private int edge1;
    private int edge2;
    private double weight;

    public Edge(int edge1,int edge2, double weight)
    {
        this.edge1=edge1;
        this.edge2=edge2;
        this.weight=weight;
    }

}
