package gui.objects;

import java.awt.*;

public class Rectangle extends AbstractObject {
    protected int a;
    protected int b;

    public Rectangle(Point position, int a,int b, Color color) {
        super(position, color);
        this.a = a;
        this.b = b;
    }

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public boolean contains(int x, int y) {
        return x >= this.position.x && x <= this.position.x + this.a && y >= this.position.y && y <= this.position.y + this.b;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(this.color);
        graphics2D.drawRect(this.position.x, this.position.y, this.a, this.b);
    }
}
