package graphing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Johnny on 2/4/2016.
 */
public class GraphingEngine implements WaveListener
{
    /** List of the the wave objects where index is the tab it is on in the ui.
     * If  a wave/tab is removed in the ui the corresponding wav element should be
     * removed from the list
    */
    private ArrayList<Wave> waves;

    /** Holds all the wave data generated by the wave objects held in the waves ArrayList.
     * Like the waves arrayList, the first index corresponds to the first wave / tab in the UI.
     * The inner index will be pulled from the timeToIndex map that will map each time value to a
     * unique index.
     */
    private ArrayList<ArrayList<GraphPoint[]>> waveData;

    /**
     * This map takes double time values as its key and then the values returned
     * are the unique indexes used for to access graph data.
     */
    private Map<Double, Integer> timeToIndex;

    private double xMin = -5;
    private double xMax = 5;

    private int numPoints = 100;

    /**
     * This variable is simply a counter used by the map for unique values
     * each time a value is added to the map it must be incremented
     */
    private int dataIndex;

    /**
     * Creates a new graphing engine object with an initially empty set of waves and given initial values
     *
     * @param xMin the minimum x value used when generating graph data
     * @param xMax the maximum x value used when generating graph data
     * @param numPoints  the number of points used when generating graph data
     */
    public GraphingEngine(double xMin, double xMax, int numPoints)
    {
        this(null, xMin, xMax, numPoints);
    }

    /**
     * Creates a new graphing engine object with an initially empty set of waves and given initial values
     *
     * @param waves a initial set of waves that the graphing engine will use.
     *              If null is passed, an empty set of waves will used.
     * @param xMin the minimum x value used when generating graph data
     * @param xMax the maximum x value used when generating graph data
     * @param numPoints  the number of points used when generating graph data
     */
    public GraphingEngine(ArrayList<Wave> waves, double xMin, double xMax, int numPoints)
    {
        if(waves == null)
            this.waves = new ArrayList<Wave>();
        else
            this.waves = waves;

        timeToIndex = new HashMap<Double, Integer>();
        this.xMin = xMin;
        this.xMax = xMax;
        this.numPoints = numPoints;

        dataIndex = 0;

    }

    /**
     * Gets the wave data for a single wave at a single point in time.
     * If the data has not been computed yet, the engine will generate it
     *
     * @param time the time value for the data
     * @param waveID the wave id of the wave whos data is being pulled
     *
     * @return an array of GraphPoints corresponding to that requested wave at the requested time.
     */
    public GraphPoint[] getWaveData(double time, int waveID)
    {
        if(timeToIndex.containsKey(time))
        {
            return waveData.get(waveID).get(timeToIndex.get(time));
        }
        else
        {
            //generate this data for all waves since its very likely this will be called
            //on the other wave very soon since this call is likely from the ui to redraw
            generateData(time);
            return waveData.get(waveID).get(timeToIndex.get(time));
        }
    }

    /**
     * This method will generate data for all the waves for a given time.
     *
     * @param time the time input used to generate the wave data.
     */
    public void generateData(double time)
    {
        timeToIndex.put(time, dataIndex++);

        //At some point it could be beneficial to have a thread for each wave generating data.
        for(int i = 0; i < waves.size(); i++)
        {
            GraphPoint [] newPoints = waves.get(i).GeneratePoints(time);
            waveData.get(i).set(timeToIndex.get(time), newPoints);
        }
    }

    /**
     * Sets the graphing engines xMin value.
     * Note - This will cause the system to dump
     * all its currently stored data as that data depends on
     * the xMin staying the same. This is of course
     * sometimes necessary, but should be avoided if possible.
     *
     * @param xMin - the new xMin
     */
    public void setXMin(double xMin)
    {
        this.xMin = xMin;

        clearWaveData();
        updateWaveXValues();
    }

    /**
     * Sets the graphing engines xMax value.
     * Note - This will cause the system to dump
     * all its currently stored data as that data depends on
     * the xMax staying the same. This is of course
     * sometimes necessary, but should be avoided if possible.
     *
     * @param xMax - the new xMax
     */
    public void setXMax(double xMax)
    {
        this.xMax = xMax;

        clearWaveData();
        updateWaveXValues();
    }

    /**
     * Sets the graphing engine's numPoints value.
     * Note - This will cause the system to dump
     * all its currently stored data as that data depends on
     * the the number of points staying the same. This is of course
     * sometimes necessary, but should be avoided if possible.
     *
     * @param numPoints - the new xMax
     */
    public void setNumPoints(int numPoints)
    {
        this.numPoints = numPoints;

        clearWaveData();
        updateWaveXValues();
    }

    /**
     * This method updates all the waves' number of points
     */
    private void updateWaveNumPoints()
    {
        for(Wave w : waves)
        {
            w.setDataPoints(new GraphPoint[numPoints]);
        }
    }
    /**
     * This method updates all the waves' x values
     */
    private void updateWaveXValues()
    {
        for(Wave w : waves)
        {
            w.setxStart(xMin);
            w.setxEnd(xMax);
        }
    }

    /**
     * This method clears all the saved wave data. This
     * this is used when x min or max is changed and
     * all the data needs to be recomputed
     */
    private void clearWaveData()
    {
        dataIndex = 0;
        timeToIndex = new HashMap<Double, Integer>();
        waveData = new ArrayList<ArrayList<GraphPoint[]>>();
    }

    @Override
    public void waveUpdated(WaveEvent e)
    {
        if(e.getType() == WaveEvent.EventType.WAVE_ADD)
        {
            waves.add(new Wave(xMin, xMax, numPoints, e.getSettings()));
        }
        else if(e.getType() == WaveEvent.EventType.WAVE_UPDATE)
        {
            //update the wave
            waves.set(e.getWaveID(), new Wave(xMin, xMax, numPoints, e.getSettings()));

            //clear the data from the previous version of the wave
            waveData.set(e.getWaveID(), new ArrayList<GraphPoint[]>());
        }
        else if (e.getType() == WaveEvent.EventType.WAVE_RESET)
        {
            //update the wave
            waves.set(e.getWaveID(), new Wave(xMin, xMax, numPoints, e.getSettings()));

            //clear the data from the previous version of the wave
            waveData.set(e.getWaveID(), new ArrayList<GraphPoint[]>());
        }
    }

    public ArrayList<Wave> getWaves() {
        return waves;
    }

    public ArrayList<ArrayList<GraphPoint[]>> getWaveData() {
        return waveData;
    }

    public double getxMin() {
        return xMin;
    }

    public double getxMax() {
        return xMax;
    }
}