package graphing;

/**
 * Created by Johnny on 1/13/2016.
 */
public class WaveSettings
{


    private double amplitude;



    private double frequency;
    private double waveLength;
    private double phaseCons;

    public WaveSettings(double amplitude, double frequency, double waveLength, double phaseCons)
    {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.waveLength = waveLength;
        this.phaseCons = phaseCons;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public double getWaveLength() {
        return waveLength;
    }

    public void setWaveLength(double waveLength) {
        this.waveLength = waveLength;
    }

    public double getPhaseCons() {
        return phaseCons;
    }

    public void setPhaseCons(double phaseCons) {
        this.phaseCons = phaseCons;
    }
}
