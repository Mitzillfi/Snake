import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Body {
    private int locX;
    private int locY;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private int headBody;

    public Body(int x, int y) {
        locX = x;
        locY = y;
    }

    public Body(int x, int y, int headBody) {
        this(x, y);
        this.headBody = headBody;
    }

    public void draw(Graphics g) {
        switch (headBody) {
            case 0:
                g.setColor(Color.green);
                g.fillRect(locX, locY, WIDTH, HEIGHT);

                break;
            case 1:
                g.setColor(Color.yellow);
                g.fillRect(locX, locY, WIDTH, HEIGHT);

                break;

            default:
                break;
        }
        g.setColor(Color.blue);
        g.drawPolyline(new int[] { locX, locX, locX + WIDTH, locX + WIDTH, locX },
                new int[] { locY + HEIGHT, locY, locY, locY + HEIGHT, locY + HEIGHT }, 5);

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