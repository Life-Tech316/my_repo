import java.awt.*;
import javax.swing.*;

public class Main_612{
  public static void main(String[] args){
    JFrame frame = new JFrame("初めましてのGUI");
    JLabel label = new JLabel("Hello world");
    JButton button = new JButton("押してね");

    frame.getContentPane().setLayout(new FlowLayout());
    frame.getContentPane().add(label);
    frame.getContentPane().add(button);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,100);
    frame.setVisible(true);
  }
}
