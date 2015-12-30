package layout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Johnny on 6/14/2015.
 */
public class Main extends JFrame
{
    public Main()
    {
        super("Flora Wave Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocation(5, 5);
        this.setResizable(false);

        JSplitPane mainPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        mainPanel.setSize(this.getSize());

;

        //divider settings
        mainPanel.setDividerSize(7);
        mainPanel.setDividerLocation(.75); //set the divider to be at 75% of the total width
        mainPanel.setEnabled(false); //lock the divider in place (may change in the future)

        //add the panels
        mainPanel.setLeftComponent(new GraphPane());
        mainPanel.setRightComponent(new OptionsPane((int)(this.getWidth()*.25), this.getHeight()));

        //add the main panel
        this.setLayout(new GridLayout(1, 1));
        this.add(mainPanel);

    }


    public static void main(String[] args)
    {
        Main waveViewer = new Main();

        waveViewer.setVisible(true);
    }
}


