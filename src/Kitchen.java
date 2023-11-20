import java.awt.Image;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Kitchen extends JFrame implements Room{
    private int sizecheck = 0;
    private JButton button;
    private JButton sink;
    private JButton table;
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
                sink.setBounds(50,0,735,370);
                table.setBounds(180,250,450,170);
                button.setText("축소");
                setSizecheck(1);

            } else {
                setSize(555, 380);
                setLocation(0, 373);
                sink.setBounds(40,0,500,275);
                table.setBounds(120,170,300,150);
                button.setText("확대");
                setSizecheck(0);
            }
        });
        add(button);



        table=new JButton("");
        table.setContentAreaFilled(false);
        table.setBounds(120,170,300,150);
        add(table);
        table.addActionListener(e -> {
            JFrame tableFrame = new JFrame("Table Panel");
            tableFrame.setLocation(0,0);
            tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            TablePanel tablePanel = new TablePanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            tableFrame.add(tablePanel);//애니멀프레임 창에 animalPanel을 추가
            tableFrame.pack();//컨테이너의 크기 조정
            tableFrame.setVisible(true);

        });
        sink=new JButton("");
        sink.setContentAreaFilled(false);
        sink.setBounds(40,0,505,273);
        add(sink);
        sink.addActionListener(e -> {
            JFrame sinkFrame = new JFrame("Sink Panel");
            sinkFrame.setLocation(0,0);
            sinkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 부모 창만 종료
            SinkPanel sinkPanel = new SinkPanel(this);//AnimalPanel클래스를 선언하고 room3객체를 전달
            sinkFrame.add(sinkPanel);//애니멀프레임 창에 animalPanel을 추가
            sinkFrame.pack();//컨테이너의 크기 조정
            sinkFrame.setVisible(true);

        });
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
    public void setSinkIcon(ImageIcon icon) {
        sink.setIcon(icon); // BedB 버튼에 아이콘을 설정하는 메서드
        sink.setBorderPainted(false);
    }
    public void setTableIcon(ImageIcon icon) {
        table.setIcon(icon); // BedB 버튼에 아이콘을 설정하는 메서드
        table.setBorderPainted(false);
    }
    public static void main(String[] args) {
        new Kitchen();
    }
}
