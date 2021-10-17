
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Thread;
import java.util.ArrayList;

public class Screen extends JPanel implements Runnable {
    private final int WIDTH = 500, HEIGHT = 500;
    ArrayList<Body> bodies = new ArrayList<Body>();
    private Food food;
    private boolean running = false;
    Thread thread = new Thread(this, "Game Thread");
    private boolean left, right, up = true, down;
    private boolean gameStart = true;
    private Score score;

    public Screen() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(listener);

    }

    public void init() {
        for (int i = 0; i < 3; i++) {
            Body body = new Body(250, 250 + i * 10);
            bodies.add(body);
        }
        food = new Food();
        score = new Score();

    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        food.draw(g);
        score.draw(g);
        if (gameStart) {
            for (int i = 0; i <= WIDTH / 10; i++) {
                g.drawLine(0, i * 10, WIDTH, i * 10);
            }
            for (int i = 0; i <= HEIGHT / 10; i++) {
                g.drawLine(i * 10, 0, i * 10, HEIGHT);

            }
            gameStart = false;
        }
        for (int i = 0; i < bodies.size(); i++) {
            bodies.get(i).draw(g);
        }
    }

    @Override
    public void run() {

        while (running) {

            update();
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }

    }

    public void update() {

        for (int i = bodies.size() - 1; i > 0; i--) {
            bodies.get(i).setLocY(bodies.get(i - 1).getLocY());
            bodies.get(i).setLocX(bodies.get(i - 1).getLocX());
        }
        if (up) {

            bodies.get(0).moveY(-10);
            bodies.get(0).moveX(0);

            if (bodies.get(0).getLocY() < 0)
                bodies.get(0).setLocY(500 - 10);

        } else if (down) {

            bodies.get(0).moveY(10);
            bodies.get(0).moveX(0);
            if (bodies.get(0).getLocY() >= 500)
                bodies.get(0).setLocY(0 + 10);

        } else if (left) {

            bodies.get(0).moveY(0);
            bodies.get(0).moveX(-10);
            if (bodies.get(0).getLocX() < 0)
                bodies.get(0).setLocX(500 - 10);

        } else if (right) {

            bodies.get(0).moveY(0);
            bodies.get(0).moveX(10);
            if (bodies.get(0).getLocX() >= 500)
                bodies.get(0).setLocX(0 + 10);

        }
        if (food.isIn(bodies.get(0).getlocXY())) {
            Body b = new Body(bodies.get(bodies.size() - 1).getLocX(), bodies.get(bodies.size() - 1).getLocY());
            bodies.add(b);
            score.addPoint();
            
            food.move();
        }

    }

    public final void start() {
        if (!running) {
            running = true;

            thread.start();
        }
    }

    KeyListener listener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == 'w' && !down) {
                up = true;
                down = false;
                left = false;
                right = false;
                
            } else if (e.getKeyChar() == 's' && !up) {
                up = false;
                down = true;
                left = false;
                right = false;
                
            } else if (e.getKeyChar() == 'a' && !right) {
                up = false;
                down = false;
                left = true;
                right = false;
                
            } else if (e.getKeyChar() == 'd' && !left) {
                up = false;
                down = false;
                left = false;
                right = true;
                
            }
        }
    };

}