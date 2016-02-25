package layout;

import graphing.GraphPoint;
import graphing.GraphingEngine;
import graphing.Wave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

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

    private GraphingEngine graphingEngine;

    public GraphPane()
    {
        super();
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Graph"));

        this.xMin = -5;
        this.xMax = 5;

        this.yMin = -5;
        this.yMax = 5;

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

        //draw the gridlines
        if(gridLines)
        {
            for(int i = 0; i < 21; i++)
            {
                //draw vert lines
                g2.draw(new Line2D.Double(xGridLineStep * i + boarder.left, boarder.top,
                                          xGridLineStep * i + boarder.left, this.getHeight() - boarder.bottom));
                //draw horiz line
                g2.draw(new Line2D.Double(boarder.left, yGridLineStep * i + boarder.top,
                                        this.getWidth() - boarder.right, yGridLineStep * i + boarder.top));
            }
        }

        //draw the tick marks on the axis
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));

        double midX = xGridLineStep * 10 + boarder.left;
        double midY = yGridLineStep * 10 + boarder.top;

        for(int i = 0; i < 21; i++)
        {
            //draw vert lines
            g2.draw(new Line2D.Double(xGridLineStep * i + boarder.left, midY - 10, xGridLineStep * i + boarder.left, midY + 10));

            //draw horiz line
            g2.draw(new Line2D.Double(midX - 10, yGridLineStep * i + boarder.top, midX + 10, yGridLineStep * i + boarder.top));
        }

        //draw the X axis
        g2.setStroke(new BasicStroke(4));

        if((int) Math.rint(sizeY) % 2  == 1)
            g2.setStroke(new BasicStroke(5));


        //The x Axis should be the middle grid line so we will reuse the code from that
        g2.draw(new Line2D.Double(boarder.left, yGridLineStep * 10 + boarder.top,
                this.getWidth() - boarder.right, yGridLineStep * 10 + boarder.top));

        //draw Y axis
        g2.setStroke(new BasicStroke(4));

        if((int) Math.rint(sizeX) % 2  == 1)
            g2.setStroke(new BasicStroke(5));


        //The y Axis should be the middle grid line so we will reuse the code from that
        g2.draw(new Line2D.Double(xGridLineStep * 10 + boarder.left, boarder.top,
                xGridLineStep * 10 + boarder.left, this.getHeight() - boarder.bottom));

        ///////////////////////
        //Draw the waves
        ///////////////////////
        g2.setStroke(new BasicStroke(1));

        ArrayList<Wave> waves = graphingEngine.getWaves();

        //get the scaling factor. This is used to map the relative
        //position (yMin - yMax) to the actual pixel position
        double scalingFactor = sizeY/(yMax - yMin);

        for(int i = 0; i < waves.size(); i++)
        {
            //time will have to be made variable when animation is added
            GraphPoint[] waveData = graphingEngine.getWaveData(0, i);

            for(int j = boarder.left; j < waveData.length-1 - boarder.right; j++)
            {
                double modifiedYStart = this.getHeight()- boarder.bottom - ((yMax + waveData[j].getPosY()) * scalingFactor);
                double modifiedYEnd = this.getHeight()- boarder.bottom - ((yMax + waveData[j+1].getPosY()) * scalingFactor);

                g2.draw(new Line2D.Double(j, modifiedYStart, j+1, modifiedYEnd));

            }
        }
    }

    public GraphingEngine getGraphingEngine() {
        return graphingEngine;
    }

    public void setGraphingEngine(GraphingEngine graphingEngine) {
        this.graphingEngine = graphingEngine;
    }

    public double getxMax() {
        return xMax;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }

    public double getyMin() {
        return yMin;
    }

    public void setyMin(double yMin) {
        this.yMin = yMin;
    }

    public double getyMax() {
        return yMax;
    }

    public void setyMax(double yMax) {
        this.yMax = yMax;
    }

    public double getxStep() {
        return xStep;
    }

    public void setxStep(double xStep) {
        this.xStep = xStep;
    }

    public double getyStep() {
        return yStep;
    }

    public void setyStep(double yStep) {
        this.yStep = yStep;
    }

    public boolean isGridLines() {
        return gridLines;
    }

    public void setGridLines(boolean gridLines) {
        this.gridLines = gridLines;
    }

    public double getxMin() {
        return xMin;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
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
