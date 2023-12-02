import java.awt.*;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class room1 extends JFrame implements Room{
    private int sizecheck = 0;
    private JButton button;
    private JButton BedB;
    private JButton AirConB;
    public void setSizecheck(int cnt) {
        this.sizecheck = cnt;
    }

    public  int getSizecheck() {
        return sizecheck;
    }
    public room1() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 0);
        setLayout(null);



        button = new JButton("확대");
        button.setBounds(10, 10, 60, 30);

        //button.setBorderPainted(false); // Remove the button's border
        //button.setContentAreaFilled(false); // Make the button background transparent
        button.addActionListener(e -> {
            if (sizecheck == 0) {
                setSize(500, 500);
                BedB.setBounds(150,235,310,160);
                AirConB.setBounds(80,25,340,70);
                button.setText("축소");
                setSizecheck(1);

            } else {
                setSize(380, 380);
                BedB.setBounds(100,170,250,120);
                button.setText("확대");
                AirConB.setBounds(50,20,300,50);
                setSizecheck(0);

            }
        });
        add(button);

        BedB=new JButton("");
        BedB.setContentAreaFilled(false);
        BedB.setBounds(100,170,250,120);
        add(BedB);
        BedB.addActionListener(e -> {
            JFrame bedFrame = new JFrame("1000원씩 비싸지는 침대");
            bedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            BedPanel BedPanel = new BedPanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            bedFrame.add(BedPanel);//애니멀프레임 창에 animalPanel을 추가
            bedFrame.pack();//컨테이너의 크기 조정
            bedFrame.setVisible(true);
            bedFrame.setLocation(0,340);

        });

        AirConB=new JButton("");AirConB.setContentAreaFilled(false);
        AirConB.setBounds(50,20,300,50);
        AirConB.addActionListener(e -> {
            JFrame AirFrame= new JFrame("1000원씩 비싸지는 에어컨");
            AirFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            AirconPanel airPanel = new AirconPanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            AirFrame.add(airPanel);//애니멀프레임 창에 animalPanel을 추가
            AirFrame.pack();//컨테이너의 크기 조정
            AirFrame.setVisible(true);
            AirFrame.setBounds(300,0,500,500);

        });
        add(AirConB);

        ImageIcon icon = new ImageIcon("img/room1.png");
        Image img = icon.getImage();
        Image changeImg = img.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImg);
        JLabel lbl = new JLabel(changeIcon);
        lbl.setBounds(0, 0, 380, 380);
        add(lbl);

        setTitle("Room1");
        setSize(380, 380);
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
    public void setBedIcon(ImageIcon icon) {
        BedB.setIcon(icon); // BedB 버튼에 아이콘을 설정하는 메서드
        BedB.setBorderPainted(false);
    }
    public void setAirconIcon(ImageIcon icon) {
        AirConB.setIcon(icon); // BedB 버튼에 아이콘을 설정하는 메서드
        AirConB.setBorderPainted(false);
    }

    public static void main(String[] args) {
        new room1();new room2();new room3();new Kitchen();new GamingRoom();

    }
}
