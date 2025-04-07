package gui.objects;

import java.awt.*;

public class Square extends AbstractObject {
    protected int a;

    public Square(Point position, int a, Color color) {
        super(position, color);
        this.a = a;
    }

    public Square(int a) {
        this.a = a;
    }

    public boolean contains(int x, int y) {
        return x >= this.position.x && x <= this.position.x + this.a && y >= this.position.y && y <= this.position.y + this.a;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(this.color);
        graphics2D.drawRect(this.position.x, this.position.y, this.a, this.a);
    }
}
