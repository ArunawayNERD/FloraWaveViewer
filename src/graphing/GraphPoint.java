package graphing;

/**
 * This class is a simple implementation for a 2D point on the graph
 * @author Johnny
 * @version 1/6/2016
 */
public class GraphPoint
{
    private double posX;
    private double posY;

    public GraphPoint(double posX, double posY)
    {
        this.posX = posX;
        this.posY = posY;
    }

    public void setPoint(double posX, double posY)
    {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX()
    {
        return posX;
    }

    public double getPosY()
    {
        return posY;
    }

    public void setPosX(double newX)
    {
        this.posX = newX;
    }

    public void setPosY(double newY)
    {
        this.posY = newY;
    }


}
