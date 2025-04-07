package gui.objects;

import java.awt.*;

public class Triangle extends AbstractObject {
    protected int a;

    public Triangle(Point position, int a, Color color) {
        super(position, color);
        this.a = a;
    }

    public Triangle(int a) {
        this.a = a;
    }

    public boolean contains(int x, int y) {
        return x >= this.position.x && x <= this.position.x + this.a && y >= this.position.y && y <= this.position.y + this.a;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(this.color);
        graphics2D.drawPolygon(new int[]{this.position.x, this.position.x + a/2, this.position.x + a}, new int[]{this.position.y, this.position.y + a, this.position.y}, 3);
    }
}
