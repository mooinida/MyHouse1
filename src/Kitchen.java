import java.awt.Image;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Kitchen extends JFrame implements Room{
    private int sizecheck = 0;
    private JButton button;
    public void setSizecheck(int cnt) {
        this.sizecheck = cnt;
    }

    public  int getSizecheck() {
        return sizecheck;
    }

    public Kitchen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 373);
        setLayout(null);

        button = new JButton("확대");
        button.setBounds(10, 10, 60, 30);
        button.addActionListener(e -> {
            if (sizecheck == 0) {
                setSize(800, 500);
                setLocation(0,250);
                button.setText("축소");
                setSizecheck(1);

            } else {
                setSize(555, 380);
                setLocation(0, 373);
                button.setText("확대");
                setSizecheck(0);
            }
        });
        add(button);

        ImageIcon icon = new ImageIcon("img/room4.png");
        Image img = icon.getImage();
        Image changeImg = img.getScaledInstance(525, 350, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImg);
        JLabel lbl = new JLabel(changeIcon);
        lbl.setBounds(0, 0, 555, 380);
        add(lbl);

        setTitle("Kitchen");
        setSize(555, 380);
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
        new Kitchen();
    }
}
