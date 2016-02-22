package layout;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Johnny on 6/14/2015.
 */
public class ViewerJFrame extends JFrame
{
    private Map<String, JComponent> panels;

    public ViewerJFrame()
    {
        super("Flora Wave Viewer");

        panels = new HashMap<String, JComponent>();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocation(5, 5);
        this.setResizable(false);

        JSplitPane mainPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        mainPanel.setSize(this.getSize());

        //divider settings
        mainPanel.setDividerSize(7);
        mainPanel.setDividerLocation(.7); //set the divider to be at 75% of the total width
        mainPanel.setEnabled(false); //lock the divider in place (may change in the future)

        //add the panels
        panels.put("GraphPane", new GraphPane());
        panels.put("OptionsPane", new OptionsPane(this, (int)(this.getWidth()*.25), this.getHeight()));

        ((OptionsPane)panels.get("OptionsPane")).setOwner(this);

        mainPanel.setLeftComponent(panels.get("GraphPane"));
        mainPanel.setRightComponent(panels.get("OptionsPane"));

        //add the main panel
        this.setLayout(new GridLayout(1, 1));
        this.add(mainPanel);
    }

    public Map<String, JComponent> getPanels() {
        return panels;
    }

    public void setPanels(Map<String, JComponent> panels) {
        this.panels = panels;
    }
}


