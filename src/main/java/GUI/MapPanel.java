package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapPanel extends JPanel {

    //Panel dimensions
    private final static int pWIDTH = 1100;
    private final static int pHEIGHT = 750;

    //Co-ordinate point dimensions
    private final static int vH = 5;
    private final static int vW = 5;

    //ArrayList to store the object of type Vertex class
    private static List<Vertex> vList = new ArrayList();
    private static List<Integer> iList = new ArrayList();

    //MapPanel constructor which is run at when this class is called
    //Used to create the panel in which the Vertex and Edges are shown
    public MapPanel(){

        setBounds(0,0, pWIDTH, pHEIGHT);
        setBackground(Color.WHITE);


        Random random = new Random();

        for (int i = 0; i<5; i++){
            double rn1 = random.nextDouble(10, pHEIGHT -10);
            double rn2 = random.nextDouble(10, pHEIGHT -10);
//            System.out.println(rn1 + " i " + i);

            vList.add(new Vertex(rn1,rn2,""));


        }

    }

    //This is a method which is called automatically when the MapPanel class is called
    //It overrides the system method paintComponent which is in abstract class JComponent
    //This is done when the MapPanel extends JPanel class, since JPanel extends JComponent
    //This is also used to show the vertex and edges connected to each vertex showing all possible connections
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        allPlotsStart(g);

    }

    //This method is called in the paintComponent method when the MapPanel class is called
    //This is used to show the vertex and edges connected to each vertex showing all possible connections
    public void allPlotsStart(Graphics g){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) g;

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));
        //Setting the color of the edges
        graph2D.setColor(Color.LIGHT_GRAY);

        //Draw the edges onto the panel
        for(int i = 0; i<vList.size();i++){
            for(int j = i + 1; j<vList.size();j++){
                Line2D.Double edge = new Line2D.Double(vList.get(i).getX()+vW/2,vList.get(i).getY()+vH/2,vList.get(j).getX()+vW/2,vList.get(j).getY()+vH/2);
                graph2D.draw(edge);
            }
        }

        //Setting the color of the vertices
        graph2D.setColor(Color.BLACK);

        //Use a loop to draw the vertices
        for(Vertex v : vList){

            //Getting the X and Y coordinates from list
            double vx = v.getX();
            double vy = v.getY();

            //Creating a new object for the vertex
            Ellipse2D.Double vertexShape = new Ellipse2D.Double(vx,vy,vW,vH);

            //Draw the vertices onto the panel
            graph2D.fill(vertexShape);
            graph2D.draw(vertexShape);

            //Displays the details of each vertices
            graph2D.drawString(" ("+(int) v.getX()+","+(int) v.getY()+")",(int) v.getX()+vW,(int) v.getY()+vH);
        }

    }

    //This method is used to reset the view of the panel to the original state of just the vertices connected to each other
    public void allPlots(){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) getGraphics();

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));
        //Setting the color of the edges
        graph2D.setColor(Color.LIGHT_GRAY);

        //Draw the edges onto the panel
        for(int i = 0; i<vList.size();i++){
            for(int j = i + 1; j<vList.size();j++){
                Line2D.Double edge = new Line2D.Double(vList.get(i).getX()+vW/2,vList.get(i).getY()+vH/2,vList.get(j).getX()+vW/2,vList.get(j).getY()+vH/2);
                graph2D.draw(edge);
            }
        }

        //Setting the color of the vertices
        graph2D.setColor(Color.BLACK);

        //Use a loop to draw the vertices
        for(Vertex v : vList){

            //Getting the X and Y coordinates from list
            double vx = v.getX();
            double vy = v.getY();

            //Creating a new object for the vertex
            Ellipse2D.Double vertexShape = new Ellipse2D.Double(vx,vy,vW,vH);

            //Draw the vertices onto the panel
            graph2D.fill(vertexShape);
            graph2D.draw(vertexShape);

            //Displays the details of each vertices
            graph2D.drawString(" ("+(int) v.getX()+","+(int) v.getY()+")",(int) v.getX()+vW,(int) v.getY()+vH);
        }

    }

    public void christofidesPath(){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) getGraphics();

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));
        //Setting the color of the edges
        graph2D.setColor(Color.BLUE);

        //Draw the edges onto the panel which shows the path of Chritofides Algorithm
        for(Integer i:iList){

            if(vList.get(i+1)!=null){
                Line2D.Double edge = new Line2D.Double(vList.get(i).getX()+vW/2,vList.get(i).getY()+vH/2,vList.get(i+1).getX()+vW/2,vList.get(i+1).getY()+vH/2);
                graph2D.draw(edge);
            }

            Line2D.Double edge = new Line2D.Double(vList.get(vList.size()-1).getX()+vW/2,vList.get(vList.size()-1).getY()+vH/2,vList.get(0).getX()+vW/2,vList.get(0).getY()+vH/2);
            graph2D.draw(edge);

        }

        //Setting the color of the vertices
        graph2D.setColor(Color.BLACK);

        //Use a loop to draw the vertices
        for(Vertex v : vList){

            //Getting the X and Y coordinates from list
            double vx = v.getX();
            double vy = v.getY();

            //Creating a new object for the vertex
            Ellipse2D.Double vertexShape = new Ellipse2D.Double(vx,vy,vW,vH);

            //Draw the vertices onto the panel
            graph2D.fill(vertexShape);
            graph2D.draw(vertexShape);
        }

    }

    public void randomswapingPath(){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) getGraphics();

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));
        //Setting the color of the edges
        graph2D.setColor(Color.BLUE);

        //Draw the edges onto the panel which shows the path of Random Swaping Algorithm
        for(Integer i:iList){

            if(vList.get(i+1)!=null){
                Line2D.Double edge = new Line2D.Double(vList.get(i).getX()+vW/2,vList.get(i).getY()+vH/2,vList.get(i+1).getX()+vW/2,vList.get(i+1).getY()+vH/2);
                graph2D.draw(edge);
            }

            Line2D.Double edge = new Line2D.Double(vList.get(vList.size()-1).getX()+vW/2,vList.get(vList.size()-1).getY()+vH/2,vList.get(0).getX()+vW/2,vList.get(0).getY()+vH/2);
            graph2D.draw(edge);

        }

        //Setting the color of the vertices
        graph2D.setColor(Color.BLACK);

        //Use a loop to draw the vertices
        for(Vertex v : vList){

            //Getting the X and Y coordinates from list
            double vx = v.getX();
            double vy = v.getY();

            //Creating a new object for the vertex
            Ellipse2D.Double vertexShape = new Ellipse2D.Double(vx,vy,vW,vH);

            //Draw the vertices onto the panel
            graph2D.fill(vertexShape);
            graph2D.draw(vertexShape);
        }

    }

    public void twooptPath(){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) getGraphics();

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));
        //Setting the color of the edges
        graph2D.setColor(Color.BLUE);

        //Draw the edges onto the panel which shows the path of 2-Opt Algorithm
        for(Integer i:iList){

            if(vList.get(i+1)!=null){
                Line2D.Double edge = new Line2D.Double(vList.get(i).getX()+vW/2,vList.get(i).getY()+vH/2,vList.get(i+1).getX()+vW/2,vList.get(i+1).getY()+vH/2);
                graph2D.draw(edge);
            }

            Line2D.Double edge = new Line2D.Double(vList.get(vList.size()-1).getX()+vW/2,vList.get(vList.size()-1).getY()+vH/2,vList.get(0).getX()+vW/2,vList.get(0).getY()+vH/2);
            graph2D.draw(edge);

        }

        //Setting the color of the vertices
        graph2D.setColor(Color.BLACK);

        //Use a loop to draw the vertices
        for(Vertex v : vList){

            //Getting the X and Y coordinates from list
            double vx = v.getX();
            double vy = v.getY();

            //Creating a new object for the vertex
            Ellipse2D.Double vertexShape = new Ellipse2D.Double(vx,vy,vW,vH);

            //Draw the vertices onto the panel
            graph2D.fill(vertexShape);
            graph2D.draw(vertexShape);
        }

    }

    public void simulatedannealingPath(){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) getGraphics();

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));
        //Setting the color of the edges
        graph2D.setColor(Color.BLUE);

        //Draw the edges onto the panel which shows the path of Simulated Annealing Algorithm
        for(Integer i:iList){

            if(vList.get(i+1)!=null){
                Line2D.Double edge = new Line2D.Double(vList.get(i).getX()+vW/2,vList.get(i).getY()+vH/2,vList.get(i+1).getX()+vW/2,vList.get(i+1).getY()+vH/2);
                graph2D.draw(edge);
            }

            Line2D.Double edge = new Line2D.Double(vList.get(vList.size()-1).getX()+vW/2,vList.get(vList.size()-1).getY()+vH/2,vList.get(0).getX()+vW/2,vList.get(0).getY()+vH/2);
            graph2D.draw(edge);

        }

        //Setting the color of the vertices
        graph2D.setColor(Color.BLACK);

        //Use a loop to draw the vertices
        for(Vertex v : vList){

            //Getting the X and Y coordinates from list
            double vx = v.getX();
            double vy = v.getY();

            //Creating a new object for the vertex
            Ellipse2D.Double vertexShape = new Ellipse2D.Double(vx,vy,vW,vH);

            //Draw the vertices onto the panel
            graph2D.fill(vertexShape);
            graph2D.draw(vertexShape);
        }

    }

    public void antcolonyPath(){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) getGraphics();

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));
        //Setting the color of the edges
        graph2D.setColor(Color.BLUE);

        //Draw the edges onto the panel which shows the path of Ant Colony Algorithm
        for(Integer i:iList){

            if(vList.get(i+1)!=null){
                Line2D.Double edge = new Line2D.Double(vList.get(i).getX()+vW/2,vList.get(i).getY()+vH/2,vList.get(i+1).getX()+vW/2,vList.get(i+1).getY()+vH/2);
                graph2D.draw(edge);
            }

            Line2D.Double edge = new Line2D.Double(vList.get(vList.size()-1).getX()+vW/2,vList.get(vList.size()-1).getY()+vH/2,vList.get(0).getX()+vW/2,vList.get(0).getY()+vH/2);
            graph2D.draw(edge);

        }

        //Setting the color of the vertices
        graph2D.setColor(Color.BLACK);

        //Use a loop to draw the vertices
        for(Vertex v : vList){

            //Getting the X and Y coordinates from list
            double vx = v.getX();
            double vy = v.getY();

            //Creating a new object for the vertex
            Ellipse2D.Double vertexShape = new Ellipse2D.Double(vx,vy,vW,vH);

            //Draw the vertices onto the panel
            graph2D.fill(vertexShape);
            graph2D.draw(vertexShape);
        }

    }

}
