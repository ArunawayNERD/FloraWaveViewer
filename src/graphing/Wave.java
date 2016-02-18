package graphing;

/**
 *
 *
 * Created by Johnny on 1/13/2016.
 */
public class Wave
{
    //holds the points for a given wave
    //this will likely be changed to some 2D structure
    //when animation is added
    private GraphPoint [] dataPoints;

    //used to uniquely identify this wave for events and drawing
    private int waveID = -1;

    //hold the min and max y values computed. Used for
    //setting the Y scale if one isn't given
    private double waveYMax = Integer.MIN_VALUE;
    private double waveYMin = Integer.MAX_VALUE;

    //holds the user entered values for the wave
    private WaveSettings waveConstants;

    //holds the computed value for the wave's period
    private double period;

    //holds the value computed for omega or the (angular frequency)
    private double omega;

    //holds the waves computed waveNumber
    private double waveNumber;

    //the x min and max the wave will be graphed over
    private double xStart;
    private double xEnd;


    public Wave(double xStart, double xEnd, int numPoints, WaveSettings settings)
    {
        this.dataPoints = new GraphPoint[numPoints];
        this.xStart = xStart;
        this.xEnd = xEnd;
        this.waveConstants = settings;

        this.period = 1/waveConstants.getFrequency();
        this.omega = 2* Math.PI * waveConstants.getFrequency();
        this.waveNumber = (2 * Math.PI) / waveConstants.getWaveLength();
    }

    public GraphPoint [] GeneratePoints(double time)
    {
        //get x range so we know the x Step
        double xRange = xEnd - xStart;
        double xStep = xRange/dataPoints.length;

        //generate all the points of that wave at that point in time
        for(int i = 0; i < dataPoints.length; i++)
        {
            double xPos = xStart + (i * xStep);
            double yPos = waveConstants.getAmplitude() * Math.sin((waveNumber * xPos) - (omega * time) + waveConstants.getPhaseCons());

            //set the min and max value
            if(yPos > waveYMax)
                waveYMax = yPos;

            if(yPos < waveYMin)
                waveYMin = yPos;

            dataPoints[i] = new GraphPoint(xPos, yPos);
        }

        return dataPoints;
    }

    public int getWaveID() {
        return waveID;
    }

    public void setWaveID(int waveID) {
        this.waveID = waveID;
    }

    public double getxEnd()
    {
        return xEnd;
    }

    public void setxEnd(double xEnd)
    {
        this.xEnd = xEnd;
    }

    public GraphPoint[] getDataPoints()
    {
        return dataPoints;
    }

    public void setDataPoints(GraphPoint[] dataPoints)
    {
        this.dataPoints = dataPoints;
    }

    public double getWaveYMax()
    {
        return waveYMax;
    }

    public void setWaveYMax(double waveYMax)
    {
        this.waveYMax = waveYMax;
    }

    public double getWaveYMin()
    {
        return waveYMin;
    }

    public void setWaveYMin(double waveYMin)
    {
        this.waveYMin = waveYMin;
    }

    public WaveSettings getWaveConstants()
    {
        return waveConstants;
    }

    public void setWaveConstants(WaveSettings waveConstants)
    {
        this.waveConstants = waveConstants;
    }

    public double getPeriod()
    {
        return period;
    }

    public void setPeriod(double period)
    {
        this.period = period;
    }

    public double getOmega()
    {
        return omega;
    }

    public void setOmega(double omega)
    {
        this.omega = omega;
    }

    public double getWaveNumber()
    {
        return waveNumber;
    }

    public void setWaveNumber(double waveNumber)
    {
        this.waveNumber = waveNumber;
    }

    public double getxStart()
    {
        return xStart;
    }

    public void setxStart(double xStart)
    {
        this.xStart = xStart;
    }
}
