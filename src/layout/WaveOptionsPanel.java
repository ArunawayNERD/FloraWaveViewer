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
    public WaveOptionsPanel()
    {
        super();

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Wave Options"));
        this.setBackground(Color.LIGHT_GRAY);

        this.setLayout(new GridBagLayout());

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
        this.add(new JLabel("Amplitude:"), constraints);

        //field
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 15);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(new JTextField(25), constraints);

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
        this.add(new JLabel("Wave length:"), constraints);

        //field
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 15);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(new JTextField(25), constraints);

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
        this.add(new JLabel("Frequency:"), constraints);
        //field
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 15);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(new JTextField(25), constraints);

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
        this.add(new JLabel("Phase Constant:"), constraints);

        //field
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(20, 0, 20, 15);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(new JTextField(25), constraints);

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
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
