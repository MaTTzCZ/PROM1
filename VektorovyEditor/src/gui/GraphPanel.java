package gui;

import gui.objects.AbstractObject;

import javax.swing.*;
import java.awt.*;
import java.util.List;



public class GraphPanel extends JPanel {
    List<AbstractObject> objektList;

    public GraphPanel(List<AbstractObject> objektList) {
        this.objektList = objektList;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2.0F));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for(AbstractObject obj : this.objektList) {
            obj.draw((Graphics2D)g);
        }

    }
}
