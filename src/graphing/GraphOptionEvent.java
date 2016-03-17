package graphing;

import java.util.EventObject;

/**
 * Created by Johnny on 3/17/2016.
 */
public class GraphOptionEvent extends EventObject
{
    private double newXMin;
    private double newXMax;

    private double newYMin;
    private double newYMax;

    private double newTimeStart;
    private double newTimeStop;

    private double newTimeStep;

    public GraphOptionEvent(Object source, double xMin, double xMax, double yMin, double yMax,
                            double timeStart, double timeStop, double timeStep)
    {
        super(source);

        newXMin = xMin;
        newXMax = xMax;

        newYMin = yMin;
        newYMax = yMax;

        newTimeStart = timeStart;
        newTimeStop = timeStop;
        newTimeStep = timeStep;
    }

    public double getNewXMin() {
        return newXMin;
    }

    public void setNewXMin(double newXMin) {
        this.newXMin = newXMin;
    }

    public double getNewXMax() {
        return newXMax;
    }

    public void setNewXMax(double newXMax) {
        this.newXMax = newXMax;
    }

    public double getNewYMin() {
        return newYMin;
    }

    public void setNewYMin(double newYMin) {
        this.newYMin = newYMin;
    }

    public double getNewYMax() {
        return newYMax;
    }

    public void setNewYMax(double newYMax) {
        this.newYMax = newYMax;
    }

    public double getNewTimeStart() {
        return newTimeStart;
    }

    public void setNewTimeStart(double newTimeStart) {
        this.newTimeStart = newTimeStart;
    }

    public double getNewTimeStop() {
        return newTimeStop;
    }

    public void setNewTimeStop(double newTimeStop) {
        this.newTimeStop = newTimeStop;
    }

    public double getNewTimeStep() {
        return newTimeStep;
    }

    public void setNewTimeStep(double newTimeStep) {
        this.newTimeStep = newTimeStep;
    }
}
