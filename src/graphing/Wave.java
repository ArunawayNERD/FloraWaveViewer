package graphing;

/**
 * Created by Johnny on 1/13/2016.
 */
public class Wave
{
    private GraphPoint [] dataPoints;

    private double WaveYMax = Integer.MIN_VALUE;
    private double WaveYMin = Integer.MAX_VALUE;

    private WaveSettings waveConstants;

    private double xStart;
    private double xEnd;


    public Wave(double xStart, double xEnd, int numPoints, WaveSettings settings)
    {
        this.dataPoints = new GraphPoint[numPoints];
        this.xStart = xStart;
        this.xEnd = xEnd;
        this.waveConstants = settings;

    }

}
