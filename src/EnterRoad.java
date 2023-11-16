import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EnterRoad extends JFrame {
    private JLabel petImg;
    private int petY=470;
    private int petX=410;
    private int petSize=100;
    public EnterRoad(){
        setTitle("집으로 가는 길");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon p= new ImageIcon("img/짱구.png");
        Image pe=p.getImage();
        Image pet=pe.getScaledInstance(petSize,petSize,Image.SCALE_SMOOTH);
        ImageIcon pet1=new ImageIcon(pet);
        petImg=new JLabel(pet1);
        petImg.setBounds(petX,petY,petSize,petSize);
        add(petImg);

        ImageIcon enter= new ImageIcon("img/enter.png");
        Image img=enter.getImage();
        Image changeEnter=img.getScaledInstance(800,600,Image.SCALE_SMOOTH);
        ImageIcon enterimg=new ImageIcon(changeEnter);
        JLabel enterI=new JLabel(enterimg);
        enterI.setSize(800,600);
        add(enterI);


        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    movePet();
                    if(petX==438){
                        new room1();new room2();new room3();new Kitchen();new GamingRoom();
                        dispose();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setSize(800,600);
        setVisible(true);
    }
    private void movePet(){
        petY-=10;
        petX+=4;
        petSize-=10;

        ImageIcon p= new ImageIcon("img/짱구.png");
        Image pe=p.getImage();
        Image pet=pe.getScaledInstance(petSize,petSize,Image.SCALE_SMOOTH);
        ImageIcon pet1=new ImageIcon(pet);
        petImg.setIcon(pet1);
        petImg.setBounds(petX,petY,petSize,petSize);

    }
    public static void main(String[] args) {
        new EnterRoad();
    }
}
