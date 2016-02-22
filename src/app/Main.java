package app;

import graphing.GraphingEngine;
import layout.GraphOptionsPanel;
import layout.GraphPane;
import layout.ViewerJFrame;
import layout.WaveOptionsPanel;

/**
 * Created by Johnny on 2/18/2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        //initialize the ui
        ViewerJFrame waveViewer = new ViewerJFrame();

        //get the ui panels which will have settings added to them
        GraphPane graphPane = (GraphPane) waveViewer.getPanels().get("GraphPane");
        WaveOptionsPanel waveOptions = (WaveOptionsPanel) waveViewer.getPanels().get("WaveOptionsPanel");
        GraphOptionsPanel graphOptions = (GraphOptionsPanel) waveViewer.getPanels().get("GraphOptionsPanel");

        waveViewer.setVisible(true);

        //set up the graphing engine
        GraphingEngine waveGraphingEngine = new GraphingEngine(graphPane, graphPane.getxMin(), graphPane.getxMax(), graphPane.getWidth());

        //give the graphs engine to the graph pane so it can use it
        graphPane.setGraphingEngine(waveGraphingEngine);

        //add the graphing engine as a listener to the wave option panel so the graphing engine will receive events
        waveOptions.addListener(waveGraphingEngine);
    }
}
