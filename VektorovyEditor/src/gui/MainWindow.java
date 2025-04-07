package gui;

import gui.objects.AbstractObject;
import gui.objects.Circle;
import gui.objects.Square;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame {
    private final List<AbstractObject> objekty = new ArrayList();

    public MainWindow() {
        super("Vektorový editor");
        this.setDefaultCloseOperation(3);
        this.add(new GraphPanel(this.objekty), "Center");
        this.initTestData();
        this.setSize(800, 600);
        this.setLocationRelativeTo((Component)null);
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
