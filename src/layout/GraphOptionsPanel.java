package layout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Johnny on 12/30/2015.
 */
public class GraphOptionsPanel extends JPanel
{
    /** This 2D  array of JPanels allows for components to be added to
     * a specific section of the grid which is normally not possible.
     * Each component will be added to the JPanel located in the desired cell
     */
    private JPanel [][] placeholderPanels;

    public GraphOptionsPanel()
    {
        super();
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Graph Options"));
        this.setBackground(Color.LIGHT_GRAY);
        //this.setLayout(new GridBagLayout());
        this.setLayout(new GridLayout(5, 4, 5, 5));

        //fill in the array of place holder panels
        placeholderPanels = new JPanel[5][4];

        for(int i  = 0; i < 5; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                placeholderPanels[i][j] = new JPanel();
                placeholderPanels[i][j].setLayout(new BorderLayout(15, 20));
                placeholderPanels[i][j].setBackground(Color.LIGHT_GRAY);
                this.add(placeholderPanels[i][j]);
            }
        }
        //init the panel component
        initComponents();
    }

    public void initComponents()
    {


        ///////////
        //X Range
        ///////////
        JLabel xMin = new JLabel("X Min:");
        xMin.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        placeholderPanels[0][0].add(xMin, BorderLayout.CENTER);

        JTextField xMinInput = new JTextField(10);
        xMinInput.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        placeholderPanels[0][1].add(xMinInput, BorderLayout.CENTER);


        JLabel xMax = new JLabel("X Max:");
        xMax.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        placeholderPanels[0][2].add(xMax, BorderLayout.CENTER);

        JTextField xMaxInput = new JTextField(10);
        xMaxInput.setBorder(BorderFactory.createEmptyBorder(20, 15,20, 15));
        placeholderPanels[0][3].add(xMaxInput, BorderLayout.CENTER);

        ///////////
        //Y Range
        ///////////
        JLabel yMin = new JLabel("Y Min:");
        yMin.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        placeholderPanels[1][0].add(yMin, BorderLayout.CENTER);

        JTextField yMinInput = new JTextField(10);
        yMinInput.setBorder(BorderFactory.createEmptyBorder(20, 15,20, 15));
        placeholderPanels[1][1].add(yMinInput, BorderLayout.CENTER);


        JLabel yMax = new JLabel("Y Max:");
        yMax.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        placeholderPanels[1][2].add(yMax, BorderLayout.CENTER);

        JTextField yMaxInput = new JTextField(10);
        yMaxInput.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        placeholderPanels[1][3].add(yMaxInput, BorderLayout.CENTER);


        ///////////
        //X Range
        ///////////
        //html is used in the JLabels because they do not support
        //the \n character....but they support html....
        JLabel timeMin = new JLabel("<html>Time<br>Start:</html>");
        timeMin.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        placeholderPanels[2][0].add(timeMin, BorderLayout.CENTER);

        JTextField timeMinInput = new JTextField(10);
        timeMinInput.setBorder(BorderFactory.createEmptyBorder(20, 15,20, 15));
        placeholderPanels[2][1].add(timeMinInput, BorderLayout.CENTER);


        JLabel timeMax = new JLabel("<html>Time<br>Stop:</html>");
        timeMax.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        placeholderPanels[2][2].add(timeMax, BorderLayout.CENTER);

        JTextField timeMaxInput = new JTextField(10);
        timeMaxInput.setBorder(BorderFactory.createEmptyBorder(20, 15,20, 15));
        placeholderPanels[2][3].add(timeMaxInput, BorderLayout.CENTER);


        /////////////
        //Time Step
        /////////////
        JLabel timeStep = new JLabel("<html>Time<br>Step:</html>");
        timeStep.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        placeholderPanels[3][1].add(timeStep, BorderLayout.CENTER);

        JTextField timeStepInput = new JTextField(10);
        timeStepInput.setBorder(BorderFactory.createEmptyBorder(20, 15,20, 15));
        placeholderPanels[3][2].add(timeStepInput, BorderLayout.CENTER);

        /////////////
        //Buttons
        /////////////
        JButton update = new JButton("Update");
        update.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        placeholderPanels[4][1].add(update, BorderLayout.CENTER);

        JButton clear = new JButton("Clear");
        clear.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        placeholderPanels[4][2].add(clear, BorderLayout.CENTER);



     /*   GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1;

        ///////////
        //X Range
        ///////////
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = .1;
        constraints.insets = new Insets(20, 15, 20, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("X Min:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 20);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(new JTextField(10), constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = .1;
        constraints.insets = new Insets(20, 0, 20, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("X Max:"), constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 20);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(new JTextField(10), constraints);


        ///////////
        //Y Range
        ///////////
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = .1;
        constraints.insets = new Insets(20, 15, 20, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Y Min:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 20);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(new JTextField(10), constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = .1;
        constraints.insets = new Insets(20, 0, 20, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Y Max:"), constraints);

        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 20);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(new JTextField(10), constraints);

        ///////////
        //Time Range
        ///////////
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = .1;
        constraints.insets = new Insets(20, 15, 20, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Time Min:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 20);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(new JTextField(10), constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = .1;
        constraints.insets = new Insets(20, 0, 20, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Time Max:"), constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 20);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(new JTextField(10), constraints);

        ////////////
        //Time Step
        ////////////
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = .1;
        constraints.insets = new Insets(20, 0, 20, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Time Step:"), constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 20, 20, 20);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(new JTextField(10), constraints);

        ///////////
        //Buttons
        ///////////
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = .25;
        constraints.insets = new Insets(15, 30, 15, 30);
        constraints.anchor = GridBagConstraints.CENTER;

        JButton submit = new JButton("Submit");
        submit.setMaximumSize(new Dimension(100, 25));
        this.add(submit, constraints);


        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = .25;
        constraints.insets = new Insets(15, 30, 15, 30);
        constraints.anchor = GridBagConstraints.CENTER;

        JButton reset = new JButton("Reset");
        reset.setMaximumSize(new Dimension(100, 25));
        this.add(reset, constraints);
        */
    }
}
