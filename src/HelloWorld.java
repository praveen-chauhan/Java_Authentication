import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorld {
    JFrame newFrame;
    HelloWorld(){
        newFrame=new JFrame("HelloWorld");
        newFrame.setSize(600, 600);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel la = new JLabel("Hello World");
        la.setBounds(100, 10, 400, 70);
        la.setFont(new Font("Ink Free",Font.BOLD,30));
        newFrame.add(la);
        newFrame.setLayout(null);
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);
    }
}
