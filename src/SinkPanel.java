import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SinkPanel extends JPanel {

    private JButton[] buttons;
    private ImageIcon[] icons;
    private Room room;
    private JButton displayButton;
    private ImageIcon save;
    private int check;
    private JLabel explain;

    public SinkPanel(Room room) {//AnimalPanel 클래스는 room3 객체를 전달받아 room3와 상호작요 할 수 있다. 이걸로 인해 room3의 버튼에 이미지를 씌울수 있다.
        this.room=  room;
        setLayout(new GridLayout(2, 3, 10, 10));
        buttons = new JButton[7];
        icons = new ImageIcon[6];

        for (int i = 0; i < 6; i++) {
            String imagePath = "img/sink" + (i + 1) + ".png";//버튼마다 각각 다른 이미지를 넣어준다
            icons[i] = createResized(imagePath, 150, 150);//가로 세로 100으로 넣어준다.
            buttons[i] = new JButton(icons[i]);//버튼에 이미지를 넣어준다
            buttons[i].setBackground(Color.WHITE);//백그라운드는 하얀색으로
            buttons[i].addActionListener(new ButtonClickListener(icons[i],i));//버튼에 actionListener를 추가해준다.
            add(buttons[i]);
        }
        buttons[6] = new JButton("정정");
        buttons[6].setBackground(Color.WHITE);

        buttons[6].addActionListener(e->{if (room.getSizecheck()==1){//확대할때

            int newWidth = 730; // 변경할 이미지의 너비
            int newHeight = 370; // 변경할 이미지의 높이

            ImageIcon resizedIcon = resizeImageIcon(save, newWidth, newHeight);
            room.setSinkIcon(resizedIcon);


        }
        else if(room.getSizecheck()==0){//축소할 때

            int newWidth = 500; // 변경할 이미지의 너비
            int newHeight = 275; // 변경할 이미지의 높이

            ImageIcon resizedIcon = resizeImageIcon(save, newWidth, newHeight);
            room.setSinkIcon(resizedIcon); // room3 클래스의 AnimalB 버튼에 아이콘(이미지임)을 설정하는 메서드 호출

        }

        });
        buttons[6].setEnabled(false);


        add(buttons[6]);

        for (int i = 0; i < 6; i++) {
            buttons[i].addActionListener(e -> {
                check = 1; // 버튼을 누르면 check를 1로 설정합니다.
                buttons[6].setEnabled(true); // buttons[6]를 활성화 상태로 변경합니다.
            });
        }

        explain= new JLabel("각 싱크대는 30000씩 비싸집니다."); // 추가된 부분

        add(explain); // 추가된 부분
    }

    private ImageIcon createResized(String path, int width, int height) {//이미지를 원하는 크기로 버튼에 넣어준다
        ImageIcon icon = new ImageIcon(path);//이미지 아이콘을 생성
        Image image = icon.getImage();//이미지 아이콘에서 이미지를 가지고 온다.
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);//원하는 사이즈로 수정한다!
        return new ImageIcon(resizedImage);// 새로운 크기의 이미지를 담은 ImageIcon을 반환
    }
    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {//이미지를 원하는 크기로 조정한다.
        Image image = icon.getImage();
        Image newImg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    // ActionListener 클래스를 내부에 구현하여 버튼 클릭 시 이벤트를 처리합니다.
    private class ButtonClickListener implements ActionListener {
        private ImageIcon icon;// 이미지 아이콘을 저장하는 이미지 아이콘
        private int index;//버튼을 클릭했을 때 버튼의 i 값을 갖고올 변수

        public ButtonClickListener(ImageIcon icon, int index) {
            this.icon = icon;//생성자를 통해 이미지 아이콘을 전달받아 이 클래스의 icon 변수에 저장
            this.index=index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int ivalue=this.index;

            if (room.getSizecheck()==1 && ControlMoney.money>=((ivalue+1)*30000)){//room3가 확대되어 있는 상태일 때.
                ControlMoney.money-=((ivalue+1)*30000);
                ControlMoney.MoneyLabel.setText("Money "+ControlMoney.money);
                save=icon;
                int newWidth = 735; // 변경할 이미지의 너비
                int newHeight = 370; // 변경할 이미지의 높이
                ImageIcon resizedIcon = resizeImageIcon(icon, newWidth, newHeight);
                room.setSinkIcon(resizedIcon);
            }
            else if(room.getSizecheck()==0 && ControlMoney.money>=((ivalue+1)*30000)){//room이 축소 되어있는 상태일 때
                ControlMoney.money-=((ivalue+1)*30000);
                ControlMoney.MoneyLabel.setText("Money "+ControlMoney.money);
                save=icon;
                int newWidth = 500; // 변경할 이미지의 너비
                int newHeight = 275; // 변경할 이미지의 높이
                ImageIcon resizedIcon = resizeImageIcon(icon, newWidth, newHeight);
                room.setSinkIcon(resizedIcon); // room 클래스의 BedB 버튼에 아이콘(이미지임)을 설정하는 메서드 호출
            }


        }

    }



}
