import javax.swing.*;
import java.awt.*;

public class FirstPage extends JFrame {

    public FirstPage(){
        setTitle("Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();


        JLabel imglabel = new JLabel(new ImageIcon("img/first.png"));
        imglabel.setBounds(0,0,800,600);
        c.add(imglabel);


        JButton start=new JButton("시작");
        JButton exit=new JButton("종료");
        Font f=new Font("맑은 고딕", Font.BOLD, 30);
        start.setBackground(Color.LIGHT_GRAY);
        exit.setBackground(Color.LIGHT_GRAY);
        start.setFont(f);
        exit.setFont(f);
        start.setBounds(350, 250, 100, 70);
        exit.setBounds(350, 350, 100, 70);

        c.add(start);
        c.add(exit);

        start.addActionListener(e->{
            setVisible(false);
            new room1();new room2();new room3();new Kitchen();new GamingRoom();
        });

        exit.addActionListener(e->{
            System.exit(0);
        });


        setLayout(null);
        setSize(800,600);
        setVisible(true);

    }




    public static void main(String[] args) {
        new FirstPage();
    }
}
