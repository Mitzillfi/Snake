import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Food {
    private int locX, locY;
    
    private final int WIDTH = 10, HEIGHT = 10;

    public Food() {
        locX = (int) (Math.random() * 30 + 10) * 10;
        locY = (int) (Math.random() * 30 + 10) * 10;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(locX, locY, WIDTH, HEIGHT);

    }

    public void move() {
        locX = (int) (Math.random() * 50) * 10;
        locY = (int) (Math.random() * 50) * 10;
    }


    public boolean isIn(Point p) {
        if (p.getY() == locY && p.getX() == locX) {
            return true;
        }
        return false;
    }

}
