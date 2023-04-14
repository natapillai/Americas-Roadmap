package GUI;

public class Vertex {

    double x;
    double y;

    boolean visited;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isVisited() {
        return visited;
    }

    public Vertex() {
    }

    public Vertex(double x, double y, boolean visited, int edges) {
        this.x = x;
        this.y = y;
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "x=" + x +
                ", y=" + y +
                ", visited=" + visited +
                '}';
    }
}
