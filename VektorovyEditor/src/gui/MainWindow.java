package gui;

import gui.objects.AbstractObject;
import gui.objects.Circle;
import gui.objects.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame {
    private final List<AbstractObject> objekty = new ArrayList();
    private GraphPanel graphPanel;
    private JToolBar jToolBar  = new JToolBar();
    ButtonGroup buttonGroup = new ButtonGroup();
    private JToggleButton jButtonSquare =  new JToggleButton("Čtverec");
    private JToggleButton jButtonCircle = new JToggleButton("Kruh");


    public MainWindow() {
        super("Vektorový editor");
        this.setDefaultCloseOperation(3);
        graphPanel = new GraphPanel(this.objekty);
        this.add(graphPanel, BorderLayout.CENTER);
        this.initTestData();
        this.setSize(800, 600);
        this.setLocationRelativeTo((Component)null);

        buttonGroup.add(jButtonCircle);
        buttonGroup.add(jButtonSquare);

        this.add(jToolBar, BorderLayout.NORTH);

        jToolBar.add(jButtonSquare);
        jToolBar.add(jButtonCircle);

        graphPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (jButtonSquare.isSelected()) {
                        objekty.add(new Square(new Point(e.getX(), e.getY()), 50, Color.BLACK));
                    }
                    else if (jButtonCircle.isSelected()) {
                        objekty.add(new Circle(new Point(e.getX(), e.getY()), 50, Color.BLACK));
                    }
                    graphPanel.repaint();
                }

            }
        });
    }

    private void initTestData() {
        this.objekty.add(new Circle(new Point(100, 100), 50, Color.BLUE));
        this.objekty.add(new Square(new Point(200, 200), 40, Color.BLACK));
        this.objekty.add(new Circle(new Point(300, 300), 10, Color.YELLOW));
        this.objekty.add(new Square(new Point(150, 200), 20, Color.GREEN));
        this.objekty.add(new Circle(new Point(350, 250), 60, Color.RED));
        this.objekty.add(new Square(new Point(400, 600), 35, Color.MAGENTA));
    }
}
