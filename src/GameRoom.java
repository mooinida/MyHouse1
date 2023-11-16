import javax.swing.JButton;
import javax.swing.JPanel;

public class GameRoom extends JPanel {

    public GameRoom() {
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        // Add buttons to the panel
        add(button1);
        add(button2);
    }

    public static void main(String[] args) {
        // Test the CustomPanel class
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GameRoom  customPanel = new GameRoom ();
                javax.swing.JFrame frame = new javax.swing.JFrame();
                frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                frame.add(customPanel);
                frame.setSize(200, 100);
                frame.setVisible(true);
            }
        });
    }
}
