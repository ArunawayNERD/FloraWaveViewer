package layout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Johnny on 12/20/2015.
 */
public class OptionsPane extends JPanel
{
    public OptionsPane()
    {
        super();
        this.setBackground(Color.LIGHT_GRAY);

        this.setLayout(new GridLayout(2, 1, 5, 5));
        this.add(new WaveOptionsPanel());
        this.add(new GraphOptionsPanel());
    }
}
