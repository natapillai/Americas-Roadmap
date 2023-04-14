package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

public class MapPanel extends JPanel {

    //Panel dimensions
    private final static int pWIDTH = 700;
    private final static int pHEIGHT = 700;

    //Co-ordinate point dimensions
    private final static int vH = 10;
    private final static int vW = 10;



    private static ArrayList<Vertex> vList = new ArrayList();
    public MapPanel(){
        setBounds(0,0, pWIDTH, pHEIGHT);
        setBackground(Color.WHITE);

        Random random = new Random();

        for (int i = 0; i<10; i++){
            double rn1 = random.nextDouble(10, pWIDTH -10);
            double rn2 = random.nextDouble(10, pWIDTH -10);
//            System.out.println(rn1 + " i " + i);

            vList.add(new Vertex(rn1,rn2,false,0));


        }

//        drawPath();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

//        JPanel panel = new JPanel();

        Graphics2D graph2D =(Graphics2D) g;
//        Graphics2D graph2D =(Graphics2D) panel.getGraphics();

//        Vertex vertex = new Vertex();



//            double V1x = 187.56114421079835;
//            double V1y = 419.40354710889324;
//            double V2x = 288.5546772814994;
//            double V2y = 543.28837632617;
//            double V3x = 517.069484367602;
//            double V3y = 699.579410352992;
//
//            vList.add(new Vertex(V1x,V1y));
//            vList.add(new Vertex(V2x,V2y));
//            vList.add(new Vertex(V3x,V3y));



//        System.out.println(vList);
//            System.out.println(rn);

//            double x = Math.random()
//            vList.add(V1y);
//            vList.add(V2x);
//            vList.add(V2y);



        graph2D.setStroke(new BasicStroke(2));
        graph2D.setColor(Color.LIGHT_GRAY);

//            int i =0;
//            for(Vertex v1: vList){
//                int j=i+1;
//                for(Vertex v2: vList){
//                    if(v2.)
//                    Line2D.Double edge = new Line2D.Double(V1x+vW/2,V1y+vH/2,V2x+vW/2,V2y+vH/2);
//                    graph2D.draw(edge);
//                }
//
//            }

        for(int i = 0; i<vList.size();i++){
            for(int j = i + 1; j<vList.size();j++){
                Line2D.Double edge = new Line2D.Double(vList.get(i).getX()+vW/2,vList.get(i).getY()+vH/2,vList.get(j).getX()+vW/2,vList.get(j).getY()+vH/2);
                graph2D.draw(edge);
            }
        }



        graph2D.setColor(Color.BLACK);

        for(Vertex v : vList){

            double vx = v.getX();
            double vy = v.getY();

            Ellipse2D.Double vertexShape = new Ellipse2D.Double(vx,vy,vW,vH);
            graph2D.fill(vertexShape);
            graph2D.draw(vertexShape);

            graph2D.drawString(" ("+(int) v.getX()+","+(int) v.getY()+")",(int) v.getX()+vW,(int) v.getY()+vH);
        }

    }

    public void drawPath(){
        Graphics2D graph2D =(Graphics2D) getGraphics();

        graph2D.setStroke(new BasicStroke(2));
        graph2D.setColor(Color.BLUE);

        for(int i = 0; i<vList.size()-1;i++){

            System.out.println(vList.get(i) + " i");
            System.out.println(vList.get(i+1) + " i+1");

            if(vList.get(i+1)!=null){
                Line2D.Double edge = new Line2D.Double(vList.get(i).getX()+vW/2,vList.get(i).getY()+vH/2,vList.get(i+1).getX()+vW/2,vList.get(i+1).getY()+vH/2);
                graph2D.draw(edge);
            }

            Line2D.Double edge = new Line2D.Double(vList.get(vList.size()-1).getX()+vW/2,vList.get(vList.size()-1).getY()+vH/2,vList.get(0).getX()+vW/2,vList.get(0).getY()+vH/2);
            graph2D.draw(edge);

        }

        graph2D.setColor(Color.BLACK);

        for(Vertex v : vList){

            double vx = v.getX();
            double vy = v.getY();

            Ellipse2D.Double vertexShape = new Ellipse2D.Double(vx,vy,vW,vH);
            graph2D.fill(vertexShape);
            graph2D.draw(vertexShape);
        }

//        for (Vertex v: vList){
//
//            double V1x = v.getX();
//            double V1y = v.getY();
//            double V2x = v.getX();
//            double V2y = v.getY();
//
//
//
//            Line2D.Double edge = new Line2D.Double(vList.get(i).getX()+vW/2,vList.get(i).getY()+vH/2,vList.get(j).getX()+vW/2,vList.get(j).getY()+vH/2);
//            graph2D.draw(edge);
//
//        }

    }

    public void drawPath1(){
        Graphics2D graph2D =(Graphics2D) getGraphics();

        graph2D.setStroke(new BasicStroke(2));
        graph2D.setColor(Color.RED);

        Line2D.Double edge = new Line2D.Double(vList.get(vList.size()-1).getX()+vW/2,vList.get(vList.size()-1).getY()+vH/2,vList.get(0).getX()+vW/2,vList.get(0).getY()+vH/2);
        graph2D.draw(edge);

    }


}
