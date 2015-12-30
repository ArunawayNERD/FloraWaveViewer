package layout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Johnny on 12/30/2015.
 */
public class GraphOptionsPanel extends JPanel
{
    public GraphOptionsPanel()
    {
        super();
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Graph Options"));
        this.setBackground(Color.LIGHT_GRAY);
    }
}
