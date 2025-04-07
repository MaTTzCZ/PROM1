package gui.objects;

import java.awt.*;

public class Circle extends AbstractObject {
    protected int radius;

    public Circle(Point position, int radius, Color color) {
        super(position, color);
        this.radius = radius;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public boolean contains(int x, int y) {
        int m = this.position.x + this.radius;
        int n = this.position.y + this.radius;
        int l = (x - m) * (x - m) + (y - n) * (y - n);
        int r = this.radius * this.radius;
        return l <= r;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(this.color);
        graphics2D.drawOval(this.position.x, this.position.y, 2 * this.radius, 2 * this.radius);
    }
}
