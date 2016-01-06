package layout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Johnny on 12/30/2015.
 */
public class WaveOptionsPanel extends JPanel
{
    public WaveOptionsPanel()
    {
        super();

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Wave Options"));
        this.setBackground(Color.LIGHT_GRAY);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }


}
