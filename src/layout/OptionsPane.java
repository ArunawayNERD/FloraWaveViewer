package layout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Johnny on 12/20/2015.
 */
public class OptionsPane extends JSplitPane
{
    public OptionsPane(int sizeX, int sizeY)
    {


        super();
        this.setBackground(Color.LIGHT_GRAY);

        this.setOrientation(JSplitPane.VERTICAL_SPLIT);

        this.setDividerSize(7);
        this.setSize(sizeX, sizeY);
        this.setDividerLocation(.47); //not sure why this isn't .5 but .47 puts the divider in the middle
        this.setEnabled(false);

        this.setLeftComponent(new WaveOptionsPanel());
        this.setRightComponent(new GraphOptionsPanel());


    }
}
