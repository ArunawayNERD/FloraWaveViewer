package graphing;

import java.util.EventObject;

/**
 * This class implements a wave event which will be used by
 * the UI to interact with the Graphing Engine
 */
public class WaveEvent extends EventObject
{
    /** The type of wave event generated */
    private final EventType type;

    /** Holds the settings for the wave which was input */
    private final WaveSettings settings;

    /** holds the id of the wave to update.
     * If its a new wave, use -1
     */
    private final int waveID;

    public WaveEvent(Object source, EventType type, int waveID, double amplitude, double waveLength, double frequency, double phaseCons)
    {
        super(source);
        this.type = type;
        settings = new WaveSettings(amplitude, waveLength, frequency, phaseCons);
        this. waveID = waveID;
    }

    public EventType getType()
    {
        return type;
    }

    public WaveSettings getSettings()
    {
        return settings;
    }

    public int getWaveID() {
        return waveID;
    }

    public enum EventType{
        WAVE_UPDATE, WAVE_RESET, WAVE_ADD;
    }
}
