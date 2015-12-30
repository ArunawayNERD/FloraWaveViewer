package layout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Johnny on 6/14/2015.
 */
public class Main extends JFrame
{
    //variables to hold the size of the grid
    private int gridRows = 2;
    private int gridCols = 5;

    //panel options
    private int graphRows = gridRows;
    private int graphCols = 4;

    private int optionRows = gridRows;
    private int optionCols = 1; //we want the options to fill whatever space the graph doesn't

    public Main()
    {
        super("Flora Wave Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);

        //create a main panel for the frame which will hold all other ui elements in a GridBagLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        //create and add the options and graph panels to the main panel
        InitPanels(mainPanel);

        //finally add the main panel
        this.setLayout(new GridLayout(1, 1));
        this.add(mainPanel);

    }

    public void InitPanels(JPanel parent)
    {
        GraphPane graph = new GraphPane();
        OptionsPane options = new OptionsPane();

        //set up the constraints common to both
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        //graph properties
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = graphRows;
        constraints.gridwidth = graphCols;
        constraints.weightx = .75;
        constraints.weighty = 1;

        //add graph panel
        parent.add(graph, constraints);

        //set the specific values for options
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridheight = optionRows;
        constraints.gridwidth = optionCols;
        constraints.weightx = .25;
        constraints.weighty = 1;


        //add the options panel
        parent.add(options, constraints);

    }


    public static void main(String[] args)
    {
        Main waveViewer = new Main();

        waveViewer.setVisible(true);
    }
}


