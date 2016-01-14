package layout;

import graphing.Wave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * The JPanel with will hold all the elements to build and display the graphing area
 * @author Johnny
 * @version 12/20/2015
 */
public class GraphPane extends JPanel implements MouseMotionListener
{
    private double xMin;
    private double xMax;

    private double yMin;
    private double yMax;

    private double xStep;
    private double yStep;

    private boolean gridLines = true; //provide options for this at some point

    private Wave[] graphs;

    public GraphPane()
    {
        super();
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Graph"));


        this.repaint();
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        Insets boarder = this.getInsets();

        //get the drawable size adjusted for the boarders
        double sizeX = this.getWidth()- boarder.right - boarder.left;
        double sizeY = this.getHeight()- boarder.top - boarder.bottom;

        double xGridLineStep = sizeX/20;
        double yGridLineStep = sizeY/20;


        System.out.println(sizeX + ", "+ sizeY + ", " + xGridLineStep + ", "+ yGridLineStep);

        //draw the gridlines
        if(gridLines)
        {
            for(int i = 0; i < 21; i++)
            {
                //draw vert lines
                g2.drawLine((int) Math.rint(xGridLineStep * i + boarder.left), boarder.top,
                            (int) Math.rint(xGridLineStep * i + boarder.left), this.getHeight() - boarder.bottom);

                //draw horiz line
                g2.drawLine(boarder.left, (int) Math.rint(yGridLineStep * i + boarder.top),
                            this.getWidth() - boarder.right,(int) Math.rint(yGridLineStep * i + boarder.top));
            }
        }

        //draw the tick marks on the axis

        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));

        int midX = (int)(xGridLineStep * 10 + boarder.left);
        int midY = (int)(yGridLineStep * 10 + boarder.top);

        for(int i = 0; i < 21; i++)
        {
            //draw vert lines
            g2.drawLine((int) Math.rint(xGridLineStep * i + boarder.left), midY - 10,
                    (int) Math.rint(xGridLineStep * i + boarder.left), midY + 10);

            //draw horiz line
            g2.drawLine(midX - 10, (int) Math.rint(yGridLineStep * i + boarder.top),
                        midX + 10,(int) Math.rint(yGridLineStep * i + boarder.top));
        }

        //draw the X
        g2.setStroke(new BasicStroke(4));

        if((int) Math.rint(sizeY) % 2  == 1)
            g2.setStroke(new BasicStroke(5));


        //The x Axis should be the middle grid line so we will reuse the code from that
        g2.drawLine(boarder.left, (int) Math.rint(yGridLineStep * 10 + boarder.top),
                this.getWidth() - boarder.right,(int) Math.rint(yGridLineStep * 10 + boarder.top));

        //draw Y axis
        g2.setStroke(new BasicStroke(4));

        if((int) Math.rint(sizeX) % 2  == 1)
            g2.setStroke(new BasicStroke(5));


        //The y Axis should be the middle grid line so we will reuse the code from that
        g2.drawLine((int) Math.rint(xGridLineStep * 10 + boarder.left), boarder.top,
                (int) Math.rint(xGridLineStep * 10 + boarder.left), this.getHeight() - boarder.bottom);

//        int thickness = 4;
//
//        if(this.getHeight() % 2  == 1)
//            thickness = 5;
//
//        for(int i = 0; i < thickness; i++)
//        {
//            g2.drawLine(boarder.left, axisStart + i, this.getWidth() - boarder.right, axisStart + i);
//        }


    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }
}
