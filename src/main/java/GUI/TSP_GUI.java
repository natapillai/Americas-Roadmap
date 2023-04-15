package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public void gui_frame(){


    }

    public TSP_GUI() {
//        this.button = button;

        setLayout(null);
        setSize(fWIDTH, fHEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        cPath = new JButton("Christofides Algorithm");
        cPath.setBounds(1105,10, 170, 40);
        cPath.addActionListener(this);

        rPath = new JButton("Random Swapping");
        rPath.setBounds(1105,60, 170, 40);
        rPath.addActionListener(this);

        tPath = new JButton("2-Opt");
        tPath.setBounds(1105,110, 170, 40);
        tPath.addActionListener(this);

        sPath = new JButton("Simulated Annealing");
        sPath.setBounds(1105,160, 170, 40);
        sPath.addActionListener(this);

        aPath = new JButton("Ant Colony");
        aPath.setBounds(1105,210, 170, 40);
        aPath.addActionListener(this);

        resetPath = new JButton("Reset");
        resetPath.setBounds(1105,260, 170, 40);
        resetPath.addActionListener(this);

        cLabel = new JLabel("Cost: ");
        cLabel.setBounds(1105,310,170,20);

        cText = new JTextField("Click on an algorithm");
        cText.setEditable(false);
        cText.setBounds(1105,330,170,40);

        mapPanel = new MapPanel();

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

    public static void main(String[] args) {
        new TSP_GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cPath){
            mapPanel.christofidesPath();
            cText.setText("christofidesPath");
        }
        if(e.getSource() == rPath){
            mapPanel.randomswapingPath();
            cText.setText("randomswapingPath");
        }

        if(e.getSource() == tPath){
            mapPanel.twooptPath();
            cText.setText("twooptPath");
        }

        if(e.getSource() == sPath){
            mapPanel.simulatedannealingPath();
            cText.setText("simulatedannealingPath");
        }

        if(e.getSource() == aPath){
            mapPanel.antcolonyPath();
            cText.setText("antcolonyPath");
        }
        if(e.getSource() == resetPath){
            mapPanel.allPlots();
            cText.setText("Click on an algorithm");
        }

    }
}
