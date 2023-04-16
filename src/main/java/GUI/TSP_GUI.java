package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TSP_GUI extends JFrame implements ActionListener {

    private final static int fWIDTH = 1300;
    private final static int fHEIGHT = 800;

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

    //Reset button to show all default vertices and edges
    private JButton resetPath;

    //Cost label
    private JLabel cLabel;

    //Cost text field
    private JTextField cText;

    private MapPanel mapPanel;

    private static List<Double> costAlgo=new ArrayList<>();

    public void gui_frame(){


    }

    public TSP_GUI(List<Vertex> vertexList,List<Integer> christo ,List<Integer> randomSwap, List<Integer> twoOpt,List<Integer> simulatedAnneling,List<Double> cost) {
//        this.button = button;

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)(size.getWidth()*0.86);
        int height = (int)(size.getHeight());

        setLayout(null);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        for(Double i:cost)
            costAlgo.add(i);

        cPath = new JButton("Christofides Algorithm");
        cPath.setBounds(width,10, 170, 40);
        cPath.addActionListener(this);

        rPath = new JButton("Random Swapping");
        rPath.setBounds(width,60, 170, 40);
        rPath.addActionListener(this);

        tPath = new JButton("2-Opt");
        tPath.setBounds(width,110, 170, 40);
        tPath.addActionListener(this);

        sPath = new JButton("Simulated Annealing");
        sPath.setBounds(width,160, 170, 40);
        sPath.addActionListener(this);

        aPath = new JButton("Ant Colony");
        aPath.setBounds(width,210, 170, 40);
        aPath.addActionListener(this);

        resetPath = new JButton("Reset");
        resetPath.setBounds(width,260, 170, 40);
        resetPath.addActionListener(this);

        cLabel = new JLabel("Cost: ");
        cLabel.setBounds(width,310,170,20);

        cText = new JTextField("Click on an algorithm");
        cText.setEditable(false);
        cText.setBounds(width,330,170,40);

        mapPanel = new MapPanel(vertexList,christo,randomSwap,twoOpt,simulatedAnneling);

        add(cPath);
        add(rPath);
        add(tPath);
        add(sPath);
        add(aPath);
        add(resetPath);
        add(cLabel);
        add(cText);
        add(mapPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cPath){
            mapPanel.christofidesPath();
            cText.setText(String.valueOf(costAlgo.get(0)));
        }
        if(e.getSource() == rPath){
            mapPanel.randomswapingPath();
            cText.setText(String.valueOf(costAlgo.get(1)));
        }

        if(e.getSource() == tPath){
            mapPanel.twooptPath();
            cText.setText(String.valueOf(costAlgo.get(2)));
        }

        if(e.getSource() == sPath){
            mapPanel.simulatedannealingPath();
            cText.setText(String.valueOf(costAlgo.get(3)));
        }

        if(e.getSource() == aPath){
            mapPanel.antcolonyPath();
            cText.setText(String.valueOf(costAlgo.get(3)));
        }
        if(e.getSource() == resetPath){
            mapPanel.allPlots();
            cText.setText("Click on an algorithm");
        }

    }
}
