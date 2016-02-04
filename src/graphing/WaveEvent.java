package graphing;

import java.util.EventObject;

/**
 * Created by Johnny on 2/4/2016.
 */
public class WaveEvent extends EventObject
{
    /** The type of wave event generated */
    private final EventType type;

    /** Holds the settings for the wave which was input */
    private final WaveSettings settings;

    public WaveEvent(Object source, EventType type, double amplitude, double waveLength, double frequency, double phaseCons)
    {
        super(source);
        this.type = type;
        settings = new WaveSettings(amplitude, waveLength, frequency, phaseCons);
    }

    public EventType getType()
    {
        return type;
    }

    public WaveSettings getSettings()
    {
        return settings;
    }

    public enum EventType{
        WAVE_UPDATE, WAVE_RESET;
    }
}
