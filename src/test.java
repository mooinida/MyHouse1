import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class test extends JFrame {
    Image a= new ImageIcon("img/강아지.jpg").getImage();
    int x=0,y=0;
    public test(){
        setTitle("Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();

        setLayout(null);
        setSize(800,600);
        setVisible(true);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                int key=e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_UP:
                        y += 20;
                        break;
                    case KeyEvent.VK_DOWN:
                        y += 10;
                        break;
                    case KeyEvent.VK_LEFT:
                        x += 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        x += 30;
                        break;
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        requestFocus();
        setFocusable(true);

    }
    public void paint(Graphics g){
        super.paintComponents(g);
        g.drawImage(a,x,y,null);
    }

    public static void main(String[] args) {
        new test();
    }
}
