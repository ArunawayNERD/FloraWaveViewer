package layout;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Created by Johnny on 12/20/2015.
 */
public class OptionsPane extends JSplitPane
{
    private ViewerJFrame owner;

    public OptionsPane(ViewerJFrame owner, int sizeX, int sizeY)
    {
        super();

        this.owner = owner;

        this.setBackground(Color.LIGHT_GRAY);

        this.setOrientation(JSplitPane.VERTICAL_SPLIT);

        this.setDividerSize(7);
        this.setSize(sizeX, sizeY);
        this.setDividerLocation(.47); //not sure why this isn't .5 but .47 puts the divider in the middle
        this.setEnabled(false);

        WaveOptionsPanel waveOptions = new WaveOptionsPanel();
        GraphOptionsPanel graphOptions = new GraphOptionsPanel();

        Map<String, JComponent> panels = owner.getPanels();
        panels.put("WaveOptionsPanel", waveOptions);
        panels.put("GraphOptionsPanel", graphOptions);

        this.setLeftComponent(waveOptions);
        this.setRightComponent(graphOptions);
    }

    public Component getOwner() {
        return owner;
    }

    public void setOwner(ViewerJFrame owner) {
        this.owner = owner;
    }


}
