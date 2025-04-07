package gui.objects;

import java.awt.*;

public abstract class AbstractObject {
    protected Point position;
    protected Color color;

    public AbstractObject(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    public AbstractObject() {
        this.position = new Point(0, 0);
        this.color = Color.BLACK;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        this.position = new Point(x, y);
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract boolean contains(int x, int y);

    public abstract void draw(Graphics2D graphics2D);
}
