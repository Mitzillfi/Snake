import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Score {
    private int score=0;

    public void draw(Graphics g) {
        g.setColor(Color.cyan);
        g.drawString("score : "+ score+"", 250, 10);
        g.setFont(new Font("Comics Sans", Font.PLAIN, 40)); 
    }
    public void addPoint() {
        this.score += 1;   
    }
    public int getScore() {
        return score;
    }
}