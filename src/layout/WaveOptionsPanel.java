package layout;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johnny on 12/30/2015.
 */
public class WaveOptionsPanel extends JPanel implements ActionListener
{
    /**
     * This holds the four input text fields so they can be accessed by the action event
     * The inputs will be in the following order. Amplitude, wave length, frequency,phase constant
     */
    private JTextField [] inputs;

    public WaveOptionsPanel()
    {
        super();

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Wave Options"));
        this.setBackground(Color.LIGHT_GRAY);

        this.setLayout(new GridBagLayout());

        inputs = new JTextField[4];

        //init the panel component
        initComponents();
    }

    public void initComponents()
    {
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
        if(e.getSource() instanceof JButton)
        {
            JButton clicked = (JButton) e.getSource();

            if(clicked.getText() == "Submit")
            {
                String [] inputValues = {inputs[0].getText(), inputs[1].getText(),
                                         inputs[2].getText(),inputs[3].getText()};

                //since its the submit button we need to check input

                for(int i = 0; i  < inputValues.length; i++)
                {
                    boolean inputError = false;
                    String errorMsg = "";

                    for(int j = 0; i < inputValues[i].length(); j++)
                    {

                    }

                    if(inputError)
                    {
                        System.out.println(errorMsg);
                        return;
                    }
                }

                //need to split the input around the decimal if it exists
                //because apparently the built in test for numeric strings
                //is just integers

                String [] amplitudeIn = inputs[0].getText().split("\\.");
                String [] waveLengthIn = inputs[1].getText().split("\\.");
                String [] frequencyIn = inputs[2].getText().split("\\.");
                String [] phaseIn = inputs[3].getText().split("\\.");

                boolean inputError = false;

               // System.out.println(inputs[0].getText() + " " +amplitudeIn.length + " " + waveLengthIn.length);

                //make sure they all only have one decimal
                if(amplitudeIn.length > 2)
                {
                    JOptionPane.showMessageDialog(null, "The amplitude has too many decimal points.\nPlease correct the value.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);

                    inputError = true;
                }

                if(waveLengthIn.length > 2)
                {
                    JOptionPane.showMessageDialog(null, "The wave length has too many decimal points.\nPlease correct the value.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    inputError = true;
                }

                if(frequencyIn.length > 2)
                {
                    JOptionPane.showMessageDialog(null, "The Frequency has too many decimal points.\nPlease correct the value.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    inputError = true;
                }

                if(phaseIn.length > 2)
                {
                    JOptionPane.showMessageDialog(null, "The phase constant has too many decimal points.\nPlease correct the value.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    inputError = true;
                }

                //if there is an input error exit the method
                if(inputError)
                    return;

                //if there is the correct number of
            }
        }
    }
}
