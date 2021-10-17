import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Body {
    private int locX, locY;
    private final int WIDTH = 10, HEIGHT = 10;
    public Body(int x, int y) {
        locX = x;
        locY = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.yellow);

        g.fillRect(locX, locY, WIDTH, HEIGHT);
    }

    public Point getlocXY() {

        return new Point(locX, locY);
    }

    public int getLocX() {
        return locX;
    }

    public void setLocX(int locX) {
        this.locX = locX;
    }

    public int getLocY() {
        return locY;
    }

    public void setLocY(int locY) {
        this.locY = locY;
    }

    public void moveX(int x) {
        this.locX += x;
    }

    public void moveY(int x) {
        this.locY += x;
    }
}