import javax.swing.JFrame;

public class Client extends JFrame {
    public Client() {
        setTitle("Snake");
        Screen screen = new Screen();
        screen.init();
        screen.start();
        add(screen);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Client();

    }

}