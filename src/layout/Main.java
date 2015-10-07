package layout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Johnny on 6/14/2015.
 */
public class Main extends JFrame
{
    public Main()
    {
        super("Flora Wave Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);

        //wave grid will be 4/5th the frame.
        //options the other 1/5th

        this.setLayout(new GridLayout(1, 5));


        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        Main waveViewer = new Main();

    }
}


