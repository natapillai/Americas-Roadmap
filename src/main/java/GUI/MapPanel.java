package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class MapPanel extends JPanel {

    //Instantiating integer object to store width and height of the panel
    private int pWIDTH;
    private int pHEIGHT;

    //Co-ordinate point dimensions
    private final static int vH = 5;
    private final static int vW = 5;

    //List to store the object of type Vertex class
    private static List<Vertex> vList = new ArrayList();
    //List to store the object of type Integer to store path for Christofides Algorithm
    private static List<Integer> christo = new ArrayList();
    //List to store the object of type Integer to store path for Random Swap Algorithm
    private static List<Integer> randomSwap=new ArrayList<>();
    //List to store the object of type Integer to store path for 2-Opt Algorithm
    private static List<Integer> twoOpt=new ArrayList<>();
    //List to store the object of type Integer to store path for Simulated Annealing Algorithm
    private static List<Integer> simulatedAnneling=new ArrayList<>();
    //List to store the object of type Integer to store path for Ant Colony Algorithm
    private static List<Integer> antColony =new ArrayList<>();

    //MapPanel constructor which is run at when this class is called
    //Used to create the panel in which the Vertex and Edges are shown
    public MapPanel(List<Vertex> vertexList,List<Integer> christos ,List<Integer> randomSwaps, List<Integer> twoOpts,List<Integer> simulatedAnnelings,List<Integer> antColonys){

        //Used to calculate the size of the screen and then display all the buttons and panel in a dynamic layout
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        pWIDTH = (int)(size.getWidth()*0.85);
        pHEIGHT = (int)(size.getHeight());

        //Setting all the parameters for the panel
        setBounds(0,0, pWIDTH, pHEIGHT);
        setBackground(Color.WHITE);

        //Using for loop to store all the vertex values and path connections in their respective lists
        for (int i = 0; i<vertexList.size(); i++){
            vList.add(vertexList.get(i));
            christo.add(christos.get(i));
            randomSwap.add(randomSwaps.get(i));
            twoOpt.add(twoOpts.get(i));
            simulatedAnneling.add(simulatedAnnelings.get(i));
            antColony.add(antColonys.get(i));
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

//            //Displays the details of each vertices
//            graph2D.drawString(" ("+(int) v.getX()+","+(int) v.getY()+")",(int) v.getX()+vW,(int) v.getY()+vH);
            //Displays the ID of each vertex
            graph2D.drawString(v.getId(),(int) v.getX()+vW,(int) v.getY()+vH);
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

//            //Displays the details of each vertices
//            graph2D.drawString(" ("+(int) v.getX()+","+(int) v.getY()+")",(int) v.getX()+vW,(int) v.getY()+vH);
            //Displays the ID of each vertex
            graph2D.drawString(v.getId(),(int) v.getX()+vW,(int) v.getY()+vH);
        }

    }

    //This method is used to display the path using Christofides Algorithm
    public void christofidesPath(){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) getGraphics();

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));

        //Setting the color of the edges
        graph2D.setColor(Color.BLUE);

        //Draw the edges onto the panel which shows the path of Chritofides Algorithm
        for(int i=0;i<christo.size()-1;i++){

            if(christo.get(i+1)!=null){
                Line2D.Double edge = new Line2D.Double(vList.get(christo.get(i)).getX()+vW/2,vList.get(christo.get(i)).getY()+vH/2,vList.get(christo.get(i+1)).getX()+vW/2,vList.get(christo.get(i+1)).getY()+vH/2);
                graph2D.draw(edge);
            }

            Line2D.Double edge = new Line2D.Double(vList.get(christo.get(christo.size()-1)).getX()+vW/2,vList.get(christo.get(christo.size()-1)).getY()+vH/2,vList.get(christo.get(0)).getX()+vW/2,vList.get(christo.get(0)).getY()+vH/2);
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

    //This method is used to display the path using Random Swapping Algorithm
    public void randomswapingPath(){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) getGraphics();

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));

        //Setting the color of the edges
        graph2D.setColor(Color.GREEN);

        //Draw the edges onto the panel which shows the path of Random Swaping Algorithm
        for(int i=0;i<randomSwap.size()-1;i++){

            if(randomSwap.get(i+1)!=null){
                Line2D.Double edge = new Line2D.Double(vList.get(randomSwap.get(i)).getX()+vW/2,vList.get(randomSwap.get(i)).getY()+vH/2,vList.get(randomSwap.get(i+1)).getX()+vW/2,vList.get(randomSwap.get(i+1)).getY()+vH/2);
                graph2D.draw(edge);
            }

            Line2D.Double edge = new Line2D.Double(vList.get(randomSwap.get(randomSwap.size()-1)).getX()+vW/2,vList.get(randomSwap.get(randomSwap.size()-1)).getY()+vH/2,vList.get(randomSwap.get(0)).getX()+vW/2,vList.get(randomSwap.get(0)).getY()+vH/2);
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

    //This method is used to display the path using 2-Opt Algorithm
    public void twooptPath(){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) getGraphics();

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));

        //Setting the color of the edges
        graph2D.setColor(Color.red);

        //Draw the edges onto the panel which shows the path of 2-Opt Algorithm
        for(int i=0;i<twoOpt.size()-1;i++){

            if(twoOpt.get(i+1)!=null){
                Line2D.Double edge = new Line2D.Double(vList.get(twoOpt.get(i)).getX()+vW/2,vList.get(twoOpt.get(i)).getY()+vH/2,vList.get(twoOpt.get(i+1)).getX()+vW/2,vList.get(twoOpt.get(i+1)).getY()+vH/2);
                graph2D.draw(edge);
            }

            Line2D.Double edge = new Line2D.Double(vList.get(twoOpt.get(twoOpt.size()-1)).getX()+vW/2,vList.get(twoOpt.get(twoOpt.size()-1)).getY()+vH/2,vList.get(twoOpt.get(0)).getX()+vW/2,vList.get(twoOpt.get(0)).getY()+vH/2);
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

    //This method is used to display the path using Simulated Annealing Algorithm
    public void simulatedannealingPath(){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) getGraphics();

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));

        //Setting the color of the edges
        graph2D.setColor(Color.YELLOW);

        //Draw the edges onto the panel which shows the path of Simulated Annealing Algorithm
        for(int i=0;i<simulatedAnneling.size()-1;i++){

            if(simulatedAnneling.get(i+1)!=null){
                Line2D.Double edge = new Line2D.Double(vList.get(simulatedAnneling.get(i)).getX()+vW/2,vList.get(simulatedAnneling.get(i)).getY()+vH/2,vList.get(simulatedAnneling.get(i+1)).getX()+vW/2,vList.get(simulatedAnneling.get(i+1)).getY()+vH/2);
                graph2D.draw(edge);
            }

            Line2D.Double edge = new Line2D.Double(vList.get(simulatedAnneling.get(simulatedAnneling.size()-1)).getX()+vW/2,vList.get(simulatedAnneling.get(simulatedAnneling.size()-1)).getY()+vH/2,vList.get(simulatedAnneling.get(0)).getX()+vW/2,vList.get(simulatedAnneling.get(0)).getY()+vH/2);
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

    //This method is used to display the path using Ant Colony Algorithm
    public void antcolonyPath(){

        //initialising the Graphics2D class to use to draw the different vertices and edges
        Graphics2D graph2D =(Graphics2D) getGraphics();

        //Setting the width of the edges
        graph2D.setStroke(new BasicStroke(1));

        //Setting the color of the edges
        graph2D.setColor(Color.CYAN);

        //Draw the edges onto the panel which shows the path of Ant Colony Algorithm
        for(int i=0;i<antColony.size()-1;i++){

            if(antColony.get(i+1)!=null){
                Line2D.Double edge = new Line2D.Double(vList.get(antColony.get(i)).getX()+vW/2,vList.get(antColony.get(i)).getY()+vH/2,vList.get(antColony.get(i+1)).getX()+vW/2,vList.get(christo.get(i+1)).getY()+vH/2);
                graph2D.draw(edge);
            }

            Line2D.Double edge = new Line2D.Double(vList.get(antColony.get(antColony.size()-1)).getX()+vW/2,vList.get(antColony.get(antColony.size()-1)).getY()+vH/2,vList.get(antColony.get(0)).getX()+vW/2,vList.get(antColony.get(0)).getY()+vH/2);
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
