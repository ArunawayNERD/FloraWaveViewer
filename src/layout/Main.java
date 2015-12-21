package layout;

import javafx.scene.layout.GridPane;

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
    private int graphCols = 3;

    private int optionRows = graphRows;
    private int optionCols = gridCols - graphCols; //we want the options to fill whatever space the graph doesn't

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
        this.setLayout(new FlowLayout());
        this.add(mainPanel);

    }

    public void InitPanels(JPanel parent)
    {
        GraphPane graph = new GraphPane();
        OptionsPane options = new OptionsPane();

        //set up the constraints common to both
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        //graph properties
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = graphRows;
        constraints.gridwidth = graphCols;

        //add graph panel
        parent.add(graph, constraints);

        //set the specific values for options
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = gridCols - graphCols;
        constraints.gridy = gridRows - graphRows;
        constraints.gridheight = optionRows;
        constraints.gridwidth = optionCols;

        //add the options panel
        parent.add(options, constraints);

    }


    public static void main(String[] args)
    {
        Main waveViewer = new Main();

        waveViewer.setVisible(true);
    }
}


