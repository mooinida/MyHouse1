import java.awt.Image;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GamingRoom extends JFrame implements Room{
    private int sizecheck = 0;
    private JButton button;
    public static JLabel GamingM;
    private JButton Pet;
    private JButton Back;
    private JButton Chair;

    public void setSizecheck(int cnt) {
        this.sizecheck = cnt;
    }
    public  int getSizecheck() {
        return sizecheck;
    }
    public GamingRoom() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(545, 373);
        setLayout(null);

        button = new JButton("확대");
        button.setBounds(10, 10, 60, 30);
        button.addActionListener(e -> {
            if (sizecheck == 0) {
                setSize(800, 500);
                setLocation(400,250);
                Pet.setBounds(300,335,130,130);
                Back.setBounds(190,120,400,240);
                Chair.setBounds(650,180,130,250);
                button.setText("축소");
                setSizecheck(1);
            } else {
                setSize(570, 380);
                setLocation(545, 373);
                button.setText("확대");
                Pet.setBounds(270,245,100,100);
                Back.setBounds(145,85,260,190);
                Chair.setBounds(450,125,100,180);
                setSizecheck(0);
            }
        });
        add(button);

        Pet=new JButton("");
        Pet.setContentAreaFilled(false);
        Pet.setBounds(270,245,100,100);
        add(Pet);
        Pet.addActionListener(e -> {
            JFrame animalFrame = new JFrame("Animal Panel");
            animalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            AnimalPanel animalPanel = new AnimalPanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            animalFrame.add(animalPanel);//애니멀프레임 창에 animalPanel을 추가
            animalFrame.pack();//컨테이너의 크기 조정
            animalFrame.setVisible(true);

        });

        Chair=new JButton("");
        Chair.setContentAreaFilled(false);
        Chair.setBounds(450,125,100,180);
        add(Chair);
        Chair.addActionListener(e -> {
            JFrame ChairFrame = new JFrame("Chair Panel");
            ChairFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            ChairPanel chairPanel = new ChairPanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            ChairFrame.add(chairPanel);//애니멀프레임 창에 animalPanel을 추가
            ChairFrame.pack();//컨테이너의 크기 조정
            ChairFrame.setVisible(true);

        });

        Back=new JButton("");
        Back.setContentAreaFilled(false);
        Back.setBounds(145,85,260,190);
        add(Back);
        Back.addActionListener(e -> {
            JFrame backFrame = new JFrame("back Panel");
            backFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            BackPanel backPanel = new BackPanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            backFrame.add(backPanel);//애니멀프레임 창에 animalPanel을 추가
            backFrame.pack();//컨테이너의 크기 조정
            backFrame.setVisible(true);

        });


        ImageIcon icon = new ImageIcon("img/room5.png");
        Image img = icon.getImage();
        Image changeImg = img.getScaledInstance(525, 350, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImg);
        JLabel lbl = new JLabel(changeIcon);
        lbl.setBounds(0, 0, 560, 380);
        add(lbl);

        setTitle("GamingRoom");
        setSize(570, 380);
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
    public void setAnimalBIcon(ImageIcon icon) {
        Pet.setIcon(icon); // AnimalB 버튼에 아이콘을 설정하는 메서드
        Pet.setBorderPainted(false);
    }
    public void setGamingBack(ImageIcon icon) {
        Back.setIcon(icon); // AnimalB 버튼에 아이콘을 설정하는 메서드//
        Back.setBorderPainted(false);
    }
    public void setChairIcon(ImageIcon icon){
        Chair.setIcon(icon);
        Chair.setBorderPainted(false);
    }
    public static void main(String[] args) {

        new room1();new room2();new room3();new Kitchen();new GamingRoom();
    }
}
