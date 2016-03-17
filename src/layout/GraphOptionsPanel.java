package layout;

import graphing.GraphOptionEvent;
import graphing.GraphOptionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    private ArrayList<GraphOptionListener> listeners;

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

        listeners = new ArrayList<GraphOptionListener>();
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
        xMinInput.setText("-5");
        constraints.weightx = 1;
        placeholderPanels[0][1].add(xMinInput, constraints);


        JLabel xMax = new JLabel("X Max (m):");
        constraints.weightx = 0;
        placeholderPanels[0][2].add(xMax, constraints);

        JTextField xMaxInput = new JTextField(10);
        xMaxInput.setText("5");
        constraints.weightx = 1;
        placeholderPanels[0][3].add(xMaxInput, constraints);

        ///////////
        //Y Range
        ///////////

        JLabel yMin = new JLabel("Y Min (m):");
        constraints.weightx = 0;
        placeholderPanels[1][0].add(yMin, constraints);

        JTextField yMinInput = new JTextField(10);
        yMinInput.setText("-5");
        constraints.weightx = 1;
        placeholderPanels[1][1].add(yMinInput, constraints);

        JLabel yMax = new JLabel("Y Max (m):");
        constraints.weightx = 0;
        placeholderPanels[1][2].add(yMax, constraints);

        JTextField yMaxInput = new JTextField(10);
        yMaxInput.setText("5");
        constraints.weightx = 1;
        placeholderPanels[1][3].add(yMaxInput, constraints);

        ///////////
        //Time range
        ///////////

        JLabel timeMin = new JLabel("Time Start (s):");
        constraints.weightx = 0;
        placeholderPanels[2][0].add(timeMin, constraints);

        JTextField timeMinInput = new JTextField(10);
        timeMinInput.setText("0");
        constraints.weightx = 1;
        placeholderPanels[2][1].add(timeMinInput, constraints);

        JLabel timeMax = new JLabel("Time Stop (s):");
        constraints.weightx = 0;
        placeholderPanels[2][2].add(timeMax, constraints);

        JTextField timeMaxInput = new JTextField(10);
        timeMaxInput.setText("10");
        constraints.weightx = 1;
        placeholderPanels[2][3].add(timeMaxInput, constraints);

        /////////////
        //Time Step
        /////////////
        JLabel timeStep = new JLabel("Time Step (s):");
        constraints.weightx = 0;
        placeholderPanels[3][1].add(timeStep, constraints);

        JTextField timeStepInput = new JTextField(10);
        timeStepInput.setText("1");
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
        update.addActionListener(this);
        placeholderPanels[4][1].add(update, constraints);

        JButton reset = new JButton("Reset");
        reset.setMargin(new Insets(20, 0, 20, 0));
        reset.addActionListener(this);
        placeholderPanels[4][2].add(reset, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() instanceof JButton)
        {
            JButton clicked = (JButton) e.getSource();

            //0-xMin, 1-xMax, 2-yMin, 3-yMax, 4-TimeStart, 5-TimeStop, 6-TimeStep
            JTextField[] inputs = {(JTextField)placeholderPanels[0][1].getComponent(0),
                    (JTextField) placeholderPanels[0][3].getComponent(0),
                    (JTextField) placeholderPanels[1][1].getComponent(0),
                    (JTextField) placeholderPanels[1][3].getComponent(0),
                    (JTextField) placeholderPanels[2][1].getComponent(0),
                    (JTextField) placeholderPanels[2][3].getComponent(0),
                    (JTextField) placeholderPanels[3][2].getComponent(0)};

            if (clicked.getText().equals("Update"))
            {
                //verify the values are all legal inputs
                for(int i = 0; i < inputs.length; i++)
                {
                    String inputValue = inputs[i].getText();

                    boolean inputError = false;
                    String errorMsg = "";

                    int decimalPointCount = 0;

                    if(inputValue.length() == 0)
                    {
                        inputError = true;
                        errorMsg += getField(i, true) + " is a required field.\nPlease enter a value.";
                    }

                    for(int j = 0; j < inputValue.length(); j++)
                    {
                        if(!inputError)
                        {
                            if (!(Character.isDigit(inputValue.charAt(j)) || inputValue.charAt(j) == '.' || inputValue.charAt(j) == '-'))
                            {

                                //if the digit is not a number or a decimal point, set the error flag and error message
                                inputError = true;
                                errorMsg += "The entered " + getField(i, false) + " is not a number.\nPlease correct the value.";

                            }

                            //a check to make sure that there are no other negative
                            // signs except for one as the first character
                            if(j != 0 && inputValue.charAt(j) == '-')
                            {
                                inputError = true;
                                errorMsg += "The entered " + getField(i, false) + " is not a valid number.\nPlease correct the value.";
                            }

                            //if the character is a decimal point then increment the counter
                            //this is to make sure we don't get numbers like 1..0 or 1.1.1 etc
                            if (inputValue.charAt(j) == '.')
                            {
                                decimalPointCount++;
                            }
                        }
                    }

                    //if there are too many decimal points set the input error flag and message
                    //We check for the input error flag here because if an input error was caught
                    // in the for loop we don't want to overwrite the error msg.
                    if(decimalPointCount > 1 && !inputError)
                    {
                        inputError = true;
                        errorMsg = "The entered value for " + getField(i, false) + " is not a valid number." +
                                    "\nPlease correct the value.";
                    }

                    //If at any point the error flag was set, then pop up an error message and exit the method
                    if (inputError)
                    {
                        JOptionPane.showMessageDialog(null, errorMsg, "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }


                //if all the entered values are valid we need to now check that
                //xMin < xMax, yMin < yMax, and timeStart < timeEnd
                //we increment i by to since we will be comparing the values of i and i+1
                for(int i = 0; i < inputs.length-1; i = i + 2)
                {

                    double inputOne = Double.valueOf(inputs[i].getText());
                    double inputTwo = Double.valueOf(inputs[i+1].getText());

                    boolean inputError = false;
                    String errorMsg = "";

                    //we are assuming that the min element is always in the list first.
                    if(inputTwo < inputOne)
                    {
                        //set the input error flag if there is an error
                        inputError = true;

                        String msg = getField(i, true) + " is greater than " + getField(i+1, false) + ".\nDo you want to " +
                                            "automatically correct this?";

                        int selection = JOptionPane.showConfirmDialog(null, msg, "Input Error",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

                        //When a user picks the yes option, the returned value is 0
                        if(selection == 0)
                        {
                            String temp = inputs[i].getText();

                            inputs[i].setText(inputs[i+1].getText());
                            inputs[i+1].setText(temp);

                            //since the error was corrected reset the input error flag
                            inputError = false;

                            JOptionPane.showMessageDialog(null, "Values corrected", "Confirm", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            //if the user picked to not correct the error generate an error message
                            errorMsg = getField(i, true) + " cannot be greater then " + getField(i+1, false) +
                                        "\nPlease correct the values";

                        }
                    }

                    if (inputError)
                    {
                        JOptionPane.showMessageDialog(null, errorMsg, "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                }

                //finally if we have made it past all the error checking send out the GraphUpdateEvent
                double xMin = Double.valueOf(inputs[0].getText());
                double xMax = Double.valueOf(inputs[1].getText());
                double yMin = Double.valueOf(inputs[2].getText());
                double yMax = Double.valueOf(inputs[3].getText());
                double timeStart = Double.valueOf(inputs[4].getText());
                double timeStop = Double.valueOf(inputs[5].getText());
                double timeStep = Double.valueOf(inputs[6].getText());

                for(GraphOptionListener l : listeners)
                {
                    l.GraphOptionUpdate(new GraphOptionEvent(this, xMin, xMax, yMin, yMax, timeStart, timeStop, timeStep));
                }
            }
            else if(clicked.getText().equals("Reset"))
            {
                inputs[0].setText("-5");
                inputs[1].setText("5");
                inputs[2].setText("-5");
                inputs[3].setText("5");
                inputs[4].setText("0");
                inputs[5].setText("10");
                inputs[6].setText("1");
            }
        }
    }

    public void addListener(GraphOptionListener listener)
    {
        listeners.add(listener);
    }

    /**
     * This method returns the name of field for the given index
     *
     * @param index The index position of the field in the inputFields array
     * @param caped Flag for if the name should be capitalized
     * @return "x Min", "x Max", "y Min", "y Max", "time start", "time stop", or "time step"
     */
    public String getField(int index, boolean caped)
    {
        String name = "";

        switch (index)
        {
            case 0: name += "x Min";
                break;

            case 1: name += "x Max";
                break;

            case 2: name += "y Min";
                break;

            case 3: name += "y Max";
                break;

            case 4: name += "time start";
                break;

            case 5: name += "time stop";
                break;

            case 6: name += "time step";
                break;
        }

        if (caped)
        {
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        }

        return name;
    }
}
