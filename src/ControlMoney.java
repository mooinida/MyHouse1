import javax.swing.*;

public class ControlMoney extends JFrame {
    public static int money=1000000;
    public static JLabel MoneyLabel;
    public ControlMoney(){
        MoneyLabel= new JLabel(""+money);
        System.out.println(MoneyLabel.getText());
    }

    public static void main(String[] args) {
        new ControlMoney();
    }
}
