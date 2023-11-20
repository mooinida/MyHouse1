import java.awt.*;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import static java.awt.Font.*;

public class room2 extends JFrame implements Room{
    private int sizecheck = 0;
    private JButton button;
    private JButton toilet;
    private JButton shower;
    private JButton LottoGame;
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

        LottoGame= new JButton("로또");
        LottoGame.setBounds(10,40,60,30);
        //LottoGame.setBackground(Color.WHITE);
        LottoGame.setContentAreaFilled(false);
        LottoGame.addActionListener(e -> {
            new Lotto();
            /*JFrame Lott=new JFrame("LOTTO");
            Lott.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Lotto LottoPanel=new Lotto();
            Lott.add(LottoPanel);
            Lott.pack();//컨테이너의 크기 조정
            Lott.setSize(700,700);
            Lott.setVisible(true);*/

        });
        add(LottoGame);

        button = new JButton("확대");
        button.setBounds(10, 10, 60, 30);
        button.addActionListener(e -> {
            if (sizecheck== 0) {
                setSize(500, 500);
                //toilet.setBounds(150,176,280,200);
                toilet.setBounds(0,266,200,200);
                shower.setBounds(95,0,389,375);
                button.setText("축소");
                setSizecheck(1);
            } else {
                setSize(280, 380);
                //toilet.setBounds(80,130,150,150);
                toilet.setBounds(0,196,150,150);
                shower.setBounds(45,0,220,280);
                button.setText("확대");
                setSizecheck(0);
            }
        });
        add(button);

        toilet=new JButton("");
        toilet.setContentAreaFilled(false);
        toilet.setBounds(0,196,150,150);
        add(toilet);
        toilet.addActionListener(e -> {
            JFrame toiletFrame = new JFrame("Toilet Panel");
            toiletFrame.setLocation(100,380);
            toiletFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            ToiletPanel toiletPanel = new ToiletPanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            toiletFrame.add(toiletPanel);//애니멀프레임 창에 animalPanel을 추가
            toiletFrame.pack();//컨테이너의 크기 조정
            toiletFrame.setVisible(true);

        });

        shower=new JButton("");
        shower.setContentAreaFilled(false);
        shower.setBounds(45,0,220,280);
        add(shower);
        shower.addActionListener(e -> {
            JFrame showerFrame = new JFrame("Shower Panel");
            showerFrame.setLocation(100,380);
            showerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            ShowerPanel showerPanel = new ShowerPanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            showerFrame.add(showerPanel);//애니멀프레임 창에 animalPanel을 추가
            showerFrame.pack();//컨테이너의 크기 조정
            showerFrame.setVisible(true);

        });

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
    public void setTIcon(ImageIcon icon) {
        toilet.setIcon(icon); // BedB 버튼에 아이콘을 설정하는 메서드
        toilet.setBorderPainted(false);
    }
    public void setShowerIcon(ImageIcon icon) {
        shower.setIcon(icon); // BedB 버튼에 아이콘을 설정하는 메서드
        shower.setBorderPainted(false);
    }

    public static void main(String[] args) {
        new room1();new room2();new room3();new Kitchen();new GamingRoom();
    }
}
