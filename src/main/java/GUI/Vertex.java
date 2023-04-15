package GUI;

public class Vertex {

    //Instantiating the variables for X & Y co-ordinate along with the ID of the vertex
    double x;
    double y;
    String id;

    //Getters for the variables X & Y co-ordinate and the ID
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getId() {
        return id;
    }

    //Empty constructor to create object of class type Vertex
    public Vertex() {
    }

    //Constructor used to create object of class type Vertex which passes X & Y co-ordinate and the ID
    public Vertex(double x, double y, String id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    //toString method which overrides the system created method to display our own string format if necessary
    @Override
    public String toString() {
        return "Vertex{" +
                "x=" + x +
                ", y=" + y +
                ", id='" + id + '\'' +
                '}';
    }
}
