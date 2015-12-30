package layout;

import javax.swing.*;
import java.awt.*;

/**
 * The JPanel with will hold all the elements to build and display the graphing area
 * Created by Johnny on 12/20/2015.
 */
public class GraphPane extends JPanel
{
    private double xMin;
    private double xMax;

    private double yMin;
    private double yMax;

    private double xStep;
    private double yStep;

    private boolean gridLines;

    public GraphPane()
    {
        super();
        this.setBackground(Color.RED);


    }


    public void paintcomponent(Graphics g)
    {
        super.paintComponent(g);
    }
}
