import java.awt.Image;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class room2 extends JFrame implements Room{
    private int sizecheck = 0;
    private JButton button;
    public void setSizecheck(int cnt) {
        this.sizecheck = cnt;
    }

    public  int getSizecheck() {
        return sizecheck;
    }
    private int money;

    public room2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(368, 0);
        setLayout(null);

        button = new JButton("확대");
        button.setBounds(10, 10, 60, 30);
        button.addActionListener(e -> {
            if (sizecheck== 0) {
                setSize(500, 500);
                button.setText("축소");
                setSizecheck(1);
            } else {
                setSize(280, 380);
                button.setText("확대");
                setSizecheck(0);
            }
        });
        add(button);



        ImageIcon icon = new ImageIcon("img/room2.png");
        Image img = icon.getImage();
        Image changeImg = img.getScaledInstance(250, 350, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImg);
        JLabel lbl = new JLabel(changeIcon);
        lbl.setBounds(0, 0, 280, 380);
        add(lbl);



        setTitle("Room2");
        setSize(280, 380);
        setVisible(true);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImg);
                lbl.setIcon(scaledIcon);
                lbl.setBounds(0, 0, getWidth()-15, getHeight()-35);
            }
        });
    }

    public static void main(String[] args) {
        new room2();
    }
}
