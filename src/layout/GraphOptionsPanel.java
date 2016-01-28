package layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johnny on 12/30/2015.
 */
public class GraphOptionsPanel extends JPanel implements ActionListener
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
        this.setLayout(new GridLayout(5, 4));

        //fill in the array of place holder panels
        placeholderPanels = new JPanel[5][4];

        for(int i  = 0; i < 5; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                placeholderPanels[i][j] = new JPanel();
                placeholderPanels[i][j].setLayout(new GridBagLayout());
                placeholderPanels[i][j].setBackground(Color.LIGHT_GRAY);
                this.add(placeholderPanels[i][j]);
            }
        }
        //init the panel component
        initComponents();
    }

    public void initComponents()
    {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(15, 0, 15, 0);

        ///////////
        //X Range
        ///////////
        JLabel xMin = new JLabel("X Min (m):");
        placeholderPanels[0][0].add(xMin, constraints);

        JTextField xMinInput = new JTextField(10);
        constraints.weightx = 1;
        placeholderPanels[0][1].add(xMinInput, constraints);


        JLabel xMax = new JLabel("X Max (m):");
        constraints.weightx = 0;
        placeholderPanels[0][2].add(xMax, constraints);

        JTextField xMaxInput = new JTextField(10);
        constraints.weightx = 1;
        placeholderPanels[0][3].add(xMaxInput, constraints);

        ///////////
        //Y Range
        ///////////

        JLabel yMin = new JLabel("Y Min (m):");
        constraints.weightx = 0;
        placeholderPanels[1][0].add(yMin, constraints);

        JTextField yMinInput = new JTextField(10);
        constraints.weightx = 1;
        placeholderPanels[1][1].add(yMinInput, constraints);

        JLabel yMax = new JLabel("Y Max (m):");
        constraints.weightx = 0;
        placeholderPanels[1][2].add(yMax, constraints);

        JTextField yMaxInput = new JTextField(10);
        constraints.weightx = 1;
        placeholderPanels[1][3].add(yMaxInput, constraints);

        ///////////
        //Time range
        ///////////

        JLabel timeMin = new JLabel("Time Start (s):");
        constraints.weightx = 0;
        placeholderPanels[2][0].add(timeMin, constraints);

        JTextField timeMinInput = new JTextField(10);
        constraints.weightx = 1;
        placeholderPanels[2][1].add(timeMinInput, constraints);

        JLabel timeMax = new JLabel("Time Stop (s):");
        constraints.weightx = 0;
        placeholderPanels[2][2].add(timeMax, constraints);

        JTextField timeMaxInput = new JTextField(10);
        constraints.weightx = 1;
        placeholderPanels[2][3].add(timeMaxInput, constraints);

        /////////////
        //Time Step
        /////////////
        JLabel timeStep = new JLabel("Time Step (s):");
        constraints.weightx = 0;
        placeholderPanels[3][1].add(timeStep, constraints);

        JTextField timeStepInput = new JTextField(10);
        constraints.weightx = 1;
        placeholderPanels[3][2].add(timeStepInput, constraints);

        /////////////
        //Buttons
        /////////////

        //adjust the insets for the buttons
        constraints.insets = new Insets(15, 5, 15, 5);
        constraints.weighty = 1;

        JButton update = new JButton("Update");
        update.setMargin(new Insets(20, 0, 20, 0));
        placeholderPanels[4][1].add(update, constraints);

        JButton clear = new JButton("Clear");
        clear.setMargin(new Insets(20, 0, 20, 0));
        placeholderPanels[4][2].add(clear, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
