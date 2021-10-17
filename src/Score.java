import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {
    private int scoreTracker = 0;

    public void draw(Graphics g) {
        g.setColor(Color.cyan);
        g.drawString("score : " + scoreTracker + "", 250, 10);
        g.setFont(new Font("Comics Sans", Font.PLAIN, 40));
    }

    public void addPoint() {
        this.scoreTracker += 1;
    }

    public int getScore() {
        return scoreTracker;
    }
}