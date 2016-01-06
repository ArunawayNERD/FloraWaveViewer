package layout;

import javax.swing.*;
import java.awt.*;

/**
 * The JPanel with will hold all the elements to build and display the graphing area
 * @author Johnny
 * @version 12/20/2015
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
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Graph"));


    }


    public void paintcomponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int sizeX = this.getWidth();
        int sizeY = this.getHeight();

        System.out.println(sizeX + ", "+ sizeY);

        //draw the X and Y axis

    }
}
