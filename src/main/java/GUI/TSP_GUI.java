package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TSP_GUI extends JFrame implements ActionListener {

    //Instantiating integer object to store width and height of the frame
    private int fWIDTH;
    private int fHEIGHT;

    //Instantiating Button for Christofides Algorithm
    private JButton cPath;

    //Instantiating Button for Random Swapping Optimization
    private JButton rPath;

    //Instantiating Button for 2-Opt Optimization
    private JButton tPath;

    //Instantiating Button for Simulated Annealing Optimization
    private JButton sPath;

    //Ant Colony Optimization
    //Instantiating Button for Ant Colony Optimization
    private JButton aPath;

    //Reset button to show all default vertices and edges
    private JButton resetPath;

    //Instantiating Label to display text "Cost: "
    private JLabel cLabel;

    //Instantiating Text Field to display Cost when clicking respective button
    private JTextField cText;

    //Instantiating the panel in which the graph wil be displayed
    private MapPanel mapPanel;

    //Initializing a list to store the cost for each algorithm
    private static List<Double> costAlgo=new ArrayList<>();

    public TSP_GUI(List<Vertex> vertexList,List<Integer> christo ,List<Integer> randomSwap, List<Integer> twoOpt,List<Integer> simulatedAnneling,List<Integer> antcolony,List<Double> cost) {

        //Used to calculate the size of the screen and then display all the buttons and panel in a dynamic layout
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        fWIDTH = (int)(size.getWidth()*0.86);
        fHEIGHT = (int)(size.getHeight());

        //Setting all the parameters for the frame
        setLayout(null);
        setSize(fWIDTH, fHEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Puts all the cost of the different algorithms into a list to display when the respective button is pressed
        for(Double i:cost) {
            costAlgo.add(i);
        }

        //Initializing the button for Christofides Algorithm, setting its parameters and add an action listener to this button
        cPath = new JButton("Christofides Algorithm");
        cPath.setBounds(fWIDTH,10, 170, 40);
        cPath.addActionListener(this);

        //Initializing the button for Random Swapping Algorithm, setting its parameters and add an action listener to this button
        rPath = new JButton("Random Swapping");
        rPath.setBounds(fWIDTH,60, 170, 40);
        rPath.addActionListener(this);

        //Initializing the button for 2-Opt Algorithm, setting its parameters and add an action listener to this button
        tPath = new JButton("2-Opt");
        tPath.setBounds(fWIDTH,110, 170, 40);
        tPath.addActionListener(this);

        //Initializing the button for Simulated Annealing Algorithm, setting its parameters and add an action listener to this button
        sPath = new JButton("Simulated Annealing");
        sPath.setBounds(fWIDTH,160, 170, 40);
        sPath.addActionListener(this);

        //Initializing the button for Ant Colony Algorithm, setting its parameters and add an action listener to this button
        aPath = new JButton("Ant Colony");
        aPath.setBounds(fWIDTH,210, 170, 40);
        aPath.addActionListener(this);

        //Initializing the button to reset the graph to its original form, setting its parameters and add an action listener to this button
        resetPath = new JButton("Reset");
        resetPath.setBounds(fWIDTH,260, 170, 40);
        resetPath.addActionListener(this);

        //Initializing the label to display the text "Cost: " and setting its parameters
        cLabel = new JLabel("Cost: ");
        cLabel.setBounds(fWIDTH,310,170,20);

        //Initializing the text field to display the respective algorithms' cost when their button is clicked and setting its parameters
        cText = new JTextField("Click on an algorithm");
        cText.setEditable(false);
        cText.setBounds(fWIDTH,330,170,40);

        //Initialising MapPanel class with inputs for each algorithm result
        mapPanel = new MapPanel(vertexList,christo,randomSwap,twoOpt,simulatedAnneling,antcolony);

        //Adding all the buttons, label, text field and JPanel to the frame
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

        //Condition to run the method christofidesPath() to display the path on the graph when cPath button is clicked
        if(e.getSource() == cPath){
            mapPanel.christofidesPath();
            cText.setText(String.valueOf(costAlgo.get(0)));
        }
        //Condition to run the method christofidesPath() to display the path on the graph when cPath button is clicked
        if(e.getSource() == rPath){
            mapPanel.randomswapingPath();
            cText.setText(String.valueOf(costAlgo.get(1)));
        }
        //Condition to run the method twooptPath() to display the path on the graph when tPath button is clicked
        if(e.getSource() == tPath){
            mapPanel.twooptPath();
            cText.setText(String.valueOf(costAlgo.get(2)));
        }
        //Condition to run the method simulatedannealingPath() to display the path on the graph when sPath button is clicked
        if(e.getSource() == sPath){
            mapPanel.simulatedannealingPath();
            cText.setText(String.valueOf(costAlgo.get(3)));
        }
        //Condition to run the method antcolonyPath() to display the path on the graph when aPath button is clicked
        if(e.getSource() == aPath){
            mapPanel.antcolonyPath();
            cText.setText(String.valueOf(costAlgo.get(4)));
        }
        //Condition to run the method allPlots() to display all edges and vertices on the graph when resetPath button is clicked
        if(e.getSource() == resetPath){
            mapPanel.allPlots();
            cText.setText("Click on an algorithm");
        }

    }

}
