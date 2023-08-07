import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class LoginPage implements ActionListener{
    JFrame frame=new JFrame("Welcome to JavaWorld");
    JButton loginButton=new JButton("Login");
    JButton resetButton=new JButton("Reset");
    JTextField userIDField =new JTextField();
    JPasswordField userPasswordField=new JPasswordField();
    JLabel userIDLabel=new JLabel("Username : ");
    JLabel userPasswordLabel=new JLabel("Password : ");
    JLabel messageLebel =new JLabel("");
    JCheckBox showPassword=new JCheckBox("Show Password",false);

    HashMap <String,String>logininfo=new HashMap<String,String>();
    LoginPage(HashMap<String,String> loginInfoOriginal){
        logininfo=loginInfoOriginal;

        showPassword.setBounds(300, 150, 150, 25);
        showPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    showPassword.setSelected(!showPassword.isSelected());
                }
                userPasswordField.setEchoChar(showPassword.isSelected() ? (char)'\u0000' : (char)'\u2022');
            }
        });
        showPassword.addActionListener(this);
        
        userIDLabel.setBounds(50, 100, 100, 25);
        userPasswordLabel.setBounds(50, 150, 100, 25);
        userIDField.setBounds(135,100,150,25);
        userPasswordField.setBounds(135,150,150,25);
        
        KeyAdapter ke=new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    loginButton.doClick();
                }
            }
        };
        userPasswordField.addKeyListener(ke);
        userIDField.addKeyListener(ke);

        
        loginButton.setBounds(100,190,100,30 );
        loginButton.addActionListener(this);
        loginButton.setFocusable(true);

        resetButton.setBounds(210,190,100,30);
        resetButton.addActionListener(this);
        resetButton.setFocusable(true);

        messageLebel.setBounds(125, 250, 250, 35);
        messageLebel.setFont(new Font("Ink Free", Font.ITALIC, 25));
        
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLebel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(showPassword);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(470,420);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setFont(new Font("Ink Free",Font.ITALIC, 30));
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
            messageLebel.setText("");
            showPassword.setSelected(false);
        }
        if(e.getSource()==loginButton){
            String userID=userIDField.getText();
            String userPassword=String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userID)){
                if(logininfo.get(userID).equals(userPassword)){
                    messageLebel.setForeground(Color.green);
                    messageLebel.setText("Login sucessful");
                    frame.dispose();
                    HelloWorld h=new HelloWorld();
                }
                else{
                    messageLebel.setForeground(Color.RED);
                    messageLebel.setText("Wrong Password");
                }
            }
            else{
                messageLebel.setForeground(Color.red);
                messageLebel.setText("Wrong userID");
            }
            

            
        }
        
        userPasswordField.setEchoChar(showPassword.isSelected() ? (char)'\u0000' : (char)'\u2022');
    }
}
