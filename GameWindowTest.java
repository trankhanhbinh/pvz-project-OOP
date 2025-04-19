import javax.swing.*;
public class GameWindowTest {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setTitle("test screen");
        window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
