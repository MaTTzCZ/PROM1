package gui;

import gui.objects.*;
import gui.objects.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame {
    private final List<AbstractObject> objekty = new ArrayList();
    private GraphPanel graphPanel;
    private JToolBar jToolBar  = new JToolBar();
    ButtonGroup buttonGroup = new ButtonGroup();
    private JToggleButton jButtonSquare =  new JToggleButton("Čtverec");
    private JToggleButton jButtonCircle = new JToggleButton("Kruh");
    private JToggleButton jButtonRectangle = new JToggleButton("Obdélník");
    private JToggleButton jButtonTriangle = new JToggleButton("Trojúhelník");
    private JToggleButton jToggleButtonMovement =  new JToggleButton("Pohyb těles");




    public MainWindow() {
        super("Vektorový editor");
        this.setDefaultCloseOperation(3);
        this.initTestData();
        graphPanel = new GraphPanel(this.objekty);
        this.add(graphPanel, BorderLayout.CENTER);
        this.setSize(800, 600);
        this.setLocationRelativeTo((Component)null);

        buttonGroup.add(jButtonCircle);
        buttonGroup.add(jButtonSquare);
        buttonGroup.add(jButtonRectangle);
        buttonGroup.add(jButtonTriangle);
        buttonGroup.add(jToggleButtonMovement);

        this.add(jToolBar, BorderLayout.NORTH);

        jToolBar.add(jButtonSquare);
        jToolBar.add(jButtonCircle);
        jToolBar.add(jButtonRectangle);
        jToolBar.add(jButtonTriangle);
        jToolBar.add(jToggleButtonMovement);


        graphPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (jButtonSquare.isSelected()) {
                        objekty.add(new Square(new Point(e.getX(), e.getY()), 50, Color.BLACK));
                    }
                    else if (jButtonCircle.isSelected()) {
                        objekty.add(new Circle(new Point(e.getX(), e.getY()), 50, Color.BLACK));
                    }
                    else if (jButtonRectangle.isSelected()) {
                        objekty.add(new Rectangle(new Point(e.getX(), e.getY()), 100, 50, Color.BLACK));
                    }
                    else if (jButtonTriangle.isSelected()) {
                        objekty.add(new Triangle(new Point(e.getX(), e.getY()), 50, Color.BLACK));
                    }
                    graphPanel.repaint();
                }

            }
        });
        final AbstractObject[] draggedObject = {null};

        graphPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (jToggleButtonMovement.isSelected()) {
                    for (AbstractObject obj : objekty) {
                        if (obj.contains(e.getX(), e.getY())) {
                            draggedObject[0] = obj;
                            break;
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                draggedObject[0] = null;
            }
        });

        graphPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (jToggleButtonMovement.isSelected() && draggedObject[0] != null) {
                    draggedObject[0].setPosition(e.getX(), e.getY());
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
