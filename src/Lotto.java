import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Lotto extends JFrame {
    private JLabel b1,b2,b3,b4,b5,b6;
    private JTextField[] submit;
    private JLabel answer,error;
    private int[] num;
    private JButton start,submitB;
    private int answerCount;
    private int submitcnt;
    private int LottoMoney=0;//로또에서 얻은 돈을 나타내준다.


    public Lotto(){

        setLocation(0, 0);
        setLayout(null);
        num=new int[6];

        ImageIcon lotto= new ImageIcon("img/돈주머니.png");
        Image img=lotto.getImage();
        Image changelotto=img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon lottoimg=new ImageIcon(changelotto);
        JLabel lottoI=new JLabel(lottoimg);
        lottoI.setBounds(490,400,200,200);
        add(lottoI);

        b1=new JLabel("A");
        b1.setFont(new Font("Serif",Font.BOLD,123));
        b1.setBounds(260,115,170,150);
        add(b1);

        b2=new JLabel("B");
        b2.setFont(new Font("Serif",Font.BOLD,80));
        b2.setBounds(410,198,100,100);
        add(b2);

        b3=new JLabel("C");
        b3.setFont(new Font("Serif",Font.BOLD,130));
        b3.setBounds(190,280,100,100);
        add(b3);

        b4=new JLabel("D");
        b4.setFont(new Font("Serif",Font.BOLD,100));
        b4.setBounds(290,370,100,100);
        add(b4);

        b5=new JLabel("E");
        b5.setFont(new Font("Serif",Font.BOLD,45));
        b5.setBounds(505,245,100,100);
        add(b5);

        b6=new JLabel("F");
        b6.setFont(new Font("Serif",Font.BOLD,90));
        b6.setBounds(435,345,100,100);
        add(b6);

        submit=new JTextField[6];
        for(int i=0;i<6;i++){
            submit[i]=new JTextField(""+(i+1));
            submit[i].setBounds(120+(40*i),520,30,30);
            add(submit[i]);
        }
        error=new JLabel("");
        error.setBounds(420,50,300,30);
        add(error);

        start=new JButton("로또 시작하기");
        start.setBounds(300,50,120,30);
        start.setBackground(Color.WHITE);
        start.addActionListener(e -> {
            if(ControlMoney.money>=10000){
                ControlMoney.money-=10000;
                ControlMoney.MoneyLabel.setText("Money "+ControlMoney.money);
                error.setText("로또 시작!! 10000을 지불합니다.");
                for(int i=0;i<6;i++){
                    num[i]=(int)(Math.random()*45)+1;
                    System.out.println(num[i]);
                }
                b1.setText("A");
                b2.setText("B");
                b3.setText("C");
                b4.setText("D");
                b5.setText("E");
                b6.setText("F");
                submitB.setEnabled(true);
                submitcnt=0;
            }
            else{
                error.setText("잔액 부족!!");
            }
        });
        add(start);

        answer=new JLabel("맞춘 갯수 : "+answerCount);
        answer.setBounds(220,600,60,30);
        add(answer);

        submitB=new JButton("제출");
        submitB.setBounds(360,520,60,30);
        submitB.setEnabled(false);
        submitB.addActionListener(e->{
            if(submitcnt==0) {//submitcnt가 0이면 abled 1이면 unabled로 한다.
                for(int i=0;i<6;i++){
                    for(int j=0;j<6;j++){
                        String text=submit[i].getText();
                        int n=Integer.parseInt(text);
                        if(n==num[j]){
                            answerCount++;
                        }
                    }
                }
                ControlMoney.money+=answerCount*10000;
                ControlMoney.MoneyLabel.setText("Money "+ControlMoney.money);
                LottoMoney+=answerCount*10000;
                System.out.println(LottoMoney);
                submitcnt++;
                answer.setText("정답 횟수"+answerCount);
                submitB.setEnabled(false);
                error.setText("로또가 종료되었습니다. 다시 시작해주십시오.");
            }

        });
        add(submitB);


        setSize(700,700);
        setVisible(true);

    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.black);
        g.drawOval(155,130,400,400);
        g.drawOval(250,170,120,120);
        g.drawOval(500,300,50,50);
        g.drawOval(420,380,90,90);
        g.drawOval(280,400,100,100);
        g.drawOval(400,240,80,80);
        g.drawOval(180,300,130,130);

    }

    public static void main(String[] args) {
        new room1();new room2();new room3();new Kitchen();new GamingRoom();
    }
}
