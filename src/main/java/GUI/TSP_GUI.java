package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TSP_GUI extends JFrame implements ActionListener {

    private final static int fWIDTH = 1200;
    private final static int fHEIGHT = 700;

    //Christofides Algorithm
    private JButton cPath;

    //Random Swapping Optimization
    private JButton rPath;

    //2-Opt Optimization
    private JButton tPath;

    //Simulated Annealing Optimization
    private JButton sPath;

    //Ant Colony Optimization
    private JButton aPath;

    private MapPanel mapPanel;

    public void gui_frame(){


    }

    public TSP_GUI() {
//        this.button = button;

        setLayout(null);
        setSize(fWIDTH, fHEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        cPath = new JButton("Christofides Algorithm");
        cPath.setBounds(750,30, 170, 40);
        cPath.addActionListener(this);

        rPath = new JButton("Random Swapping");
        rPath.setBounds(750,80, 170, 40);
        rPath.addActionListener(this);

        tPath = new JButton("2-Opt");
        tPath.setBounds(750,130, 170, 40);
        tPath.addActionListener(this);

        sPath = new JButton("Simulated Annealing");
        sPath.setBounds(750,180, 170, 40);
        sPath.addActionListener(this);

        aPath = new JButton("Ant Colony");
        aPath.setBounds(750,230, 170, 40);
        aPath.addActionListener(this);

        mapPanel = new MapPanel();

        add(cPath);
        add(rPath);
        add(tPath);
        add(sPath);
        add(aPath);
        add(mapPanel);

    }



    //    public class Vertex {
//
//        double x;
//        double y;
//
//        public double getX() {
//            return x;
//        }
//
//        public double getY() {
//            return y;
//        }
//
//        public Vertex(double x, double y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public String toString() {
//            return "Vertex{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    '}';
//        }
//    }

//    private class MapPanel extends JPanel{
//
//        public MapPanel(){
//            setBounds(0,0,width,height);
//            setBackground(Color.WHITE);
//        }
//
//
//
//        public void paintComponent(Graphics g){
//            super.paintComponent(g);
//            Graphics2D graph2D =(Graphics2D) g;
//
//            ArrayList<Vertex> vList = new ArrayList();
//
////            double V1x = 187.56114421079835;
////            double V1y = 419.40354710889324;
////            double V2x = 288.5546772814994;
////            double V2y = 543.28837632617;
////            double V3x = 517.069484367602;
////            double V3y = 699.579410352992;
////
////            vList.add(new Vertex(V1x,V1y));
////            vList.add(new Vertex(V2x,V2y));
////            vList.add(new Vertex(V3x,V3y));
//
//            Random random = new Random();
//
//
//
//            for (int i = 0; i<5; i++){
//                double rn1 = random.nextDouble(10,width-10);
//                double rn2 = random.nextDouble(10,width-10);
//                System.out.println(rn1 + " i " + i);
//
//                vList.add(new Vertex(rn1,rn2));
//
//
//            }
//
//            System.out.println(vList);
////            System.out.println(rn);
//
////            double x = Math.random()
////            vList.add(V1y);
////            vList.add(V2x);
////            vList.add(V2y);
//
//            final int vH = 10;
//            final int vW = 10;
//
//            graph2D.setStroke(new BasicStroke(2));
//            graph2D.setColor(Color.LIGHT_GRAY);
//
////            int i =0;
////            for(Vertex v1: vList){
////                int j=i+1;
////                for(Vertex v2: vList){
////                    if(v2.)
////                    Line2D.Double edge = new Line2D.Double(V1x+vW/2,V1y+vH/2,V2x+vW/2,V2y+vH/2);
////                    graph2D.draw(edge);
////                }
////
////            }
//
//            for(int i = 0; i<vList.size();i++){
//                for(int j = i + 1; j<vList.size();j++){
//                    Line2D.Double edge = new Line2D.Double(vList.get(i).getX()+vW/2,vList.get(i).getY()+vH/2,vList.get(j).getX()+vW/2,vList.get(j).getY()+vH/2);
//                    graph2D.draw(edge);
//                }
//            }
//
//
//
//            graph2D.setColor(Color.BLACK);
//
//            for(Vertex v : vList){
//
//                double vx = v.getX();
//                double vy = v.getY();
//
//                Ellipse2D.Double vertexShape = new Ellipse2D.Double(vx,vy,vW,vH);
//                graph2D.fill(vertexShape);
//                graph2D.draw(vertexShape);
//            }
//
//
//
//        }
//
//
//
//    }



    public static void main(String[] args) {
        new TSP_GUI();
//        tg.gui_frame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cPath){
            mapPanel.drawPath();
        }
        if(e.getSource() == rPath){
            mapPanel.drawPath1();
        }

        if(e.getSource() == tPath){
            mapPanel.drawPath1();
        }

        if(e.getSource() == sPath){
            mapPanel.drawPath1();
        }

        if(e.getSource() == aPath){
            mapPanel.drawPath1();
        }

    }
}
