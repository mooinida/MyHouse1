import java.awt.Image;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import java.awt.event.*;
public class room3 extends JFrame implements Room{
    private int sizecheck = 0;

    private JButton button;
    public static JButton AnimalB;
    private JButton BedB;
    private JButton AirConB;


    public void setSizecheck(int cnt) {
        this.sizecheck = cnt;
    }

    public  int getSizecheck() {
        return sizecheck;
    }

    public room3() {


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(636, 0);
        setLayout(null);

       /*JButton buy=new JButton("all-1000");
        buy.setBounds(100,100,60,30);
        buy.addActionListener(
                System.out.println(room1.room3M.getText());
        room1.room2M.setText(String.valueOf(Integer.parseInt(room1.room3M.getText())-1000));
        System.out.println(room1.room2M.getText());
        );
        add(buy);*/

        button = new JButton("확대");
        button.setBounds(10, 10, 60, 30);
        button.addActionListener(e -> {
            if (sizecheck == 0) {
                setSize(600, 500);
                button.setText("축소");
                ControlMoney.MoneyLabel.setBounds(500,0,100,30);
                AnimalB.setBounds(20,340,130,130);
                BedB.setBounds(260,235,310,160);
                AirConB.setBounds(130,35,340,70);
                setSizecheck(1);
            } else {
                setSize(480, 380);
                button.setText("확대");
                ControlMoney.MoneyLabel.setBounds(380,0,100,30);
                AnimalB.setBounds(10,245,100,100);
                BedB.setBounds(200,170,250,120);
                AirConB.setBounds(100,30,300,50);
                setSizecheck(0);
            }

        });
        add(button);

        AnimalB=new JButton("");
        AnimalB.setContentAreaFilled(false);
        AnimalB.setBounds(10,245,100,100);
        add(AnimalB);
        AnimalB.addActionListener(e -> {
            JFrame animalFrame = new JFrame("Animal Panel");
            animalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            AnimalPanel animalPanel = new AnimalPanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            animalFrame.add(animalPanel);//애니멀프레임 창에 animalPanel을 추가
            animalFrame.pack();//컨테이너의 크기 조정
            animalFrame.setVisible(true);

        });

        BedB=new JButton("");
        BedB.setContentAreaFilled(false);
        BedB.setBounds(200,170,250,120);
        add(BedB);
        BedB.addActionListener(e -> {
            JFrame bedFrame = new JFrame("1000원씩 비싸지는 침대");
            bedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            BedPanel BedPanel = new BedPanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            bedFrame.add(BedPanel);//애니멀프레임 창에 animalPanel을 추가
            bedFrame.pack();//컨테이너의 크기 조정
            bedFrame.setVisible(true);
            bedFrame.setLocation(0,380);

        });

        AirConB=new JButton("");AirConB.setContentAreaFilled(false);
        AirConB.setBounds(100,20,300,50);
        AirConB.addActionListener(e -> {
            JFrame AirFrame= new JFrame("1000원씩 비싸지는 에어컨");
            AirFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            AirconPanel airPanel = new AirconPanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            AirFrame.add(airPanel);//애니멀프레임 창에 animalPanel을 추가
            AirFrame.pack();//컨테이너의 크기 조정
            AirFrame.setVisible(true);
            AirFrame.setBounds(0,0,500,500);

        });
        add(AirConB);



        ControlMoney.MoneyLabel=new JLabel( "Money "+ControlMoney.money);//현재 예산이 얼마나 남았는지 보여준다. 모든 프레임에 동일하게 적용됨.
        ControlMoney.MoneyLabel.setBounds(380,0,100,30);//위치와 크기 설정
        add(ControlMoney.MoneyLabel);//예산이 보이게 추가해줌

        ImageIcon icon = new ImageIcon("img/room3.png");//이미지 아이콘을 선언
        Image img = icon.getImage();//이미지아이콘에서 이미지 추출
        Image changeImg = img.getScaledInstance(450, 350, Image.SCALE_SMOOTH);//이미지를 내 맘대로 크기 조정한다.
        ImageIcon changeIcon = new ImageIcon(changeImg);//그 조정한 이미지를 다시 이미지아이콘으로 변환!
        JLabel lbl = new JLabel(changeIcon);// 이미지 아이콘을 label에 넣어준다.
        lbl.setBounds(0, 0, 480, 380);
        add(lbl);

        setTitle("Room3");
        setSize(480, 380);
        setVisible(true);

        addComponentListener(new ComponentAdapter() {//구성요소들의 크기조절 이벤트를 감지하기 위해 추가
            @Override
            public void componentResized(ComponentEvent e) {//구성요소들이 크기조절이 시작되면 호출시작
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImg);
                lbl.setIcon(scaledIcon);
                lbl.setBounds(0, 0, getWidth()-15, getHeight()-35);
            }
        });
    }

    public void setAnimalBIcon(ImageIcon icon) {
        AnimalB.setIcon(icon); // AnimalB 버튼에 아이콘을 설정하는 메서드
        AnimalB.setBorderPainted(false);
    }

    @Override
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
