package layout;

import graphing.WaveEvent;
import graphing.WaveListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Johnny on 12/30/2015.
 */
public class WaveOptionsPanel extends JPanel implements ActionListener {
    /**
     * This holds the four input text fields so they can be accessed by the action event
     * The inputs will be in the following order. Amplitude, wave length, frequency,phase constant
     */
    private JTextField[] inputs;

    /**
     * Holds the objects who are listening to this object for wave events
     */
    private ArrayList<WaveListener> listeners = new ArrayList<WaveListener>();

    public WaveOptionsPanel()
    {
        super();

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Wave Options"));
        this.setBackground(Color.LIGHT_GRAY);

        this.setLayout(new GridBagLayout());

        inputs = new JTextField[4];

        //init the panel component
        initComponents();
    }

    public void initComponents() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        //      constraints.weightx = 1;
        constraints.weighty = 1;

        ///////////
        //Amplitude
        ///////////

        //label
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = .1;
        constraints.insets = new Insets(20, 15, 20, 0);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(new JLabel("Amplitude (m):"), constraints);

        //field
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 15);
        constraints.anchor = GridBagConstraints.WEST;
        inputs[0] = new JTextField(25);
        inputs[0].setText("0");
        this.add(inputs[0], constraints);

        /////////////
        //Wave length
        /////////////

        //label
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = .1;
        constraints.insets = new Insets(20, 15, 20, 0);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(new JLabel("Wave length (m):"), constraints);

        //field
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 15);
        constraints.anchor = GridBagConstraints.WEST;
        inputs[1] = new JTextField(25);
        inputs[1].setText("0");
        this.add(inputs[1], constraints);

        ///////////
        //Frequency
        ///////////

        //label
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = .1;
        constraints.insets = new Insets(20, 15, 20, 0);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(new JLabel("Frequency (m):"), constraints);
        //field
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 15);
        constraints.anchor = GridBagConstraints.WEST;
        inputs[2] = new JTextField(25);
        inputs[2].setText("0");
        this.add(inputs[2], constraints);

        /////////////////
        //Phase Constant
        /////////////////

        //label
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = .1;
        constraints.insets = new Insets(20, 15, 20, 0);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(new JLabel("Phase Constant (rad):"), constraints);

        //field
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 15);
        constraints.anchor = GridBagConstraints.WEST;
        inputs[3] = new JTextField(25);
        inputs[3].setText("0");
        this.add(inputs[3], constraints);

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
        submit.addActionListener(this);
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
        reset.addActionListener(this);
        reset.setMaximumSize(new Dimension(100, 25));
        this.add(reset, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() instanceof JButton)
        {
            JButton clicked = (JButton) e.getSource();

            if (clicked.getText().equals("Submit"))
            {
                String[] inputValues = {inputs[0].getText(), inputs[1].getText(),
                                        inputs[2].getText(), inputs[3].getText()};

                //since its the submit button we need to check input
                for (int i = 0; i < inputValues.length; i++)
                {
                    boolean inputError = false;
                    String errorMsg = "";
                    int decimalPointCount = 0;

                    //check to make sure the field isn't left empty. If it is set the flag and error message
                    //Since the length of the string is 0 in this case we don't need to worry about the for loop
                    if(inputValues[i].length() == 0)
                    {
                        inputError = true;
                        errorMsg += getField(i, true) + " is a required field.\nPlease enter a value.";
                    }

                    //we do not have to check if the input error is true yet because the only time
                    //input error is true at this point is if the input length is zero.
                    //if that is the case this loop will never run.
                    for (int j = 0; j < inputValues[i].length(); j++)
                    {
                        if(!inputError)
                        {
                            if (!(Character.isDigit(inputValues[i].charAt(j)) || inputValues[i].charAt(j) == '.' || inputValues[i].charAt(j) == '-'))
                            {

                                //if the digit is not a number or a decimal point, set the error flag and error message.
                                inputError = true;
                                errorMsg += "The entered " + getField(i, false) + " is not a number.\nPlease correct the value.";

                            }


                            //a check to make sure that there are no other negative
                            // signs except for one as the first character
                            if(j != 0 && inputValues[i].charAt(j) == '-')
                            {
                                inputError = true;
                                errorMsg += "The entered " + getField(i, false) + " is not a valid number.\nPlease correct the value.";
                            }

                            //if the character is a decimal point then increment the counter
                            //this is to make sure we don't get numbers like 1..0 or 1.1.1 etc
                            if (inputValues[i].charAt(j) == '.')
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
                        errorMsg = "The entered value for " + getField(i, false) + " is not a valid number.\nPlease correct the value.";
                    }

                    //If at any point the error flag was set, then pop up an error message and exit the method
                    if (inputError)
                    {
                        JOptionPane.showMessageDialog(null, errorMsg, "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //notify the listeners that a wave action took place
                for(WaveListener wl : listeners)
                {
                    double amplitude = Double.valueOf(inputValues[0]);
                    double waveLength = Double.valueOf(inputValues[1]);
                    double frequency = Double.valueOf(inputValues[2]);
                    double phase = Double.valueOf(inputValues[3]);

                    //the wave id will need to be made variable when multiple waves are supported
                    wl.waveUpdated(new WaveEvent(this, WaveEvent.EventType.WAVE_UPDATE, 0, amplitude, waveLength, frequency, phase));
                }
            }

            if(clicked.getText().equals("Reset"))
            {
                for(JTextField i : inputs)
                {
                    i.setText("0");
                }

                //notify the listeners that a wave action took place
                for(WaveListener wl : listeners)
                {
                    //the wave id will need to be made variable when multiple waves are supported
                    wl.waveUpdated(new WaveEvent(this, WaveEvent.EventType.WAVE_RESET, 0, 0, 0, 0, 0));
                }
            }
        }
    }

    public void addListener(WaveListener wl)
    {
        listeners.add(wl);
    }

    /**
     * This method returns the name of field for the given index
     *
     * @param index The index position of the field in the inputFields array
     * @param caped Flag for if the name should be capitalized
     * @return "amplitude", "wave length", "frequency", or "phase constant
     */
    public String getField(int index, boolean caped)
    {

        String name = "";

        switch (index)
        {
            case 0: name += "amplitude";
                    break;

            case 1: name += "wave length";
                    break;

            case 2: name += "frequency";
                    break;

            case 3: name += "phase constant";
                    break;
        }

        if (caped)
        {
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        }

        return name;
    }
}
