import javax.swing.*;
import java.awt.*;

public class Animal extends JFrame {

    public Animal(){
        setLocation(0,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,3,10,10));
        setTitle("Pet - All 1000G");

        JButton[] Button=new JButton[6];
        ImageIcon[] icon=new ImageIcon[6];

        for(int i=0;i<6;i++){
            String imagePath="img/pet"+(i+1)+".png";
            icon[i]=createResized(imagePath,100,100);
            Button[i]=new JButton(icon[i]);
            Button[i].setBackground(Color.WHITE);
            add(Button[i]);
        }
        setSize(400,400);
        setVisible(true);
    }
    private static ImageIcon createResized(String path,int width,int height){
        ImageIcon icon=new ImageIcon(path);//path의 경로에서 이미지 아이콘을 생성한다
        Image image=icon.getImage();//이미지 아이콘에서 이미지를 가져옴
        Image resizedImage=image.getScaledInstance(width,height,Image.SCALE_SMOOTH);//이미지 크기조절
        return new ImageIcon(resizedImage);//조절된 이미지로 ImageIcon 생성
    }
    public static void main(String[] args) {
        new Animal();
    }
}
