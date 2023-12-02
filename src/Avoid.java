import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Avoid extends JFrame {
    private int bx=200;
    private int by=650;
    private int bwidth=30;
    private int bheight=30;
    private List<Ball1> balls;
    private boolean gameOver=false;


    public Avoid(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 0);
        setLayout(null);

        setTitle("Avoid Snow");
        setSize(600, 700);
        setVisible(true);

        balls=new ArrayList<>();
        Random random=new Random();

        for(int i=0;i<20;i++){
            int ballSize=random.nextInt(20)+10;
            int ballX=random.nextInt(600);//x좌표는 아무곳에서나 등장해라
            int ballY=random.nextInt(100)-150;//맨 처음에 -에 숨겨놨다가 나중에 나타나게함!
            int ballSpeed= random.nextInt(10) + 1; // 떨어지는 속도

            Ball1 ball1=new Ball1(ballX,ballY,ballSize,ballSpeed) ;
            balls.add(ball1);
        }



        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(!(bx==300 && by==10)){
                    if(e.getKeyCode()==KeyEvent.VK_UP)by-=10;
                    else if (e.getKeyCode()==KeyEvent.VK_DOWN)by+=10;
                    else if (e.getKeyCode()==KeyEvent.VK_RIGHT)bx+=10;
                    else if (e.getKeyCode()==KeyEvent.VK_LEFT)bx-=10;
                    checkCollisions();
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    public void checkCollisions(){
        for(Ball1 ball: balls){
            if(ball.checkCollision(bx,by,bwidth,bheight)){
                gameOver=true;// 부딪히면 겜 종료시켜줌
                JOptionPane.showMessageDialog(null, "Game Over!");
                System.exit(0);
            }
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        Image img = createImage(getWidth(), getHeight());
        Graphics buffer = img.getGraphics();

        buffer.setColor(Color.BLACK);
        buffer.drawRect(bx, by, bwidth, bheight);
        for (Ball1 ball : balls) {
            ball.move();
            buffer.setColor(Color.RED);
            buffer.fillOval(ball.x, ball.y, ball.size, ball.size);
        }

        g.drawImage(img,0,0,this);
    }
    public static void main(String[] args) {
        Avoid avoid=new Avoid();
        Ball1Thread b=new Ball1Thread(avoid.balls,avoid);
        b.start();
    }

}


class Ball1{
    public int x;
    public int y;
    public int size;
    public int speed;
    public Ball1(int x,int y,int size,int speed){
        this.x=x;
        this.y=y;
        this.size=size;
        this.speed=speed;
    }
    public boolean checkCollision(int boxX, int boxY, int boxWidth, int boxHeight) {

        return x < boxX + boxWidth &&
                x + size > boxX &&
                y < boxY + boxHeight &&
                y + size > boxY;
    }//둘이 부딪혔는지 확인해주는 함수.

    public void move(){//y좌표를 증가시켜 볼을 내려가게 함
        y+=speed;
        //y좌표가 많이 커져 화면에서 벗어나게 되면 다시 화면 위로 올린다.
        if(y>700){
            y=-50;
            Random random=new Random();
            x=random.nextInt(550);//x좌표0~550까지 무자구이
            speed=random.nextInt(50)+1;//속도도 랜덤으로 한다. 너무 빠르면 수정가능
        }
    }
}
class Ball1Thread extends Thread{
    private List<Ball1> balls;//클래스 Ball. Ball객체들을 담고 있는 리스트
    private Avoid avoid;//Avoid class의 객체를 나타낸다. Avoid클래스에서 눈을 그려주고 내 상자를 그려주기에 선언

    public Ball1Thread(List<Ball1> balls,Avoid avoid){
        this.balls=balls;//BAll1Thread의 생성자로 balls와 avoid를 초기화했다.
        this.avoid=avoid;//이 생성자로 쓰레드에서 balls와 avoid 클래스를 관리할 수 있다.
    }
    public void run(){//thread를 만들었다면 run은 꼭 만들어야한다고 한다.
        while(true){//while문으로 공을 계속 떨어지게 한다
            for(Ball1 b:balls){//볼 리스트에 각 ball객체를 반복시킨다.
                b.move();//모든 ball 객체를 움직이게 한다.
            }
            avoid.checkCollisions(); //쓰레드를 돌리면서 부딪혔는지 확인한다. 부딪혔으면 종료되니까
            //근데 이거 없어도 그냥 종료되는건 똑같지않나?아니다 있어야 볼들이 알아서 움직일때 부딪힌다
            avoid.repaint();//다시 그려준다.

            try{
                Thread.sleep(100);//왜 쓰는지 잘 모르겠는데, 실행 속도를 일정하게 유지하고, 스레드간의 경쟁을 조절한다고 한다.
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
