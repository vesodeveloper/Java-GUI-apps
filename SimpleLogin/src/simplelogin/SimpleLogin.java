package simplelogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public abstract class SimpleLogin implements ActionListener{
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setTitle("Login Form");
        frame.setSize(200, 200);
  JTextField user=new JTextField(10);
  user.setText("Enter Username:");
  JPasswordField pass=new JPasswordField(10);
   JButton Login=new JButton("Login");
  JPanel panel= new JPanel();
  panel.add(user);
  panel.add(pass);
  panel.add(Login);
  frame.add(panel);
  Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String user_name=user.getText();
                String user_pass=pass.toString();
                if ("veso99".equals(user_name)&& "12ve12".equals(user_pass)) {
                    Login.setText("Logged!");
                }
                if (!"veso99".equals(user_name)&& !"12ve12".equals(user_pass)) {
                    Login.setText("Login Failed! Try again");
                }     }
        });
    
  frame.getContentPane().add(BorderLayout.CENTER,panel);
    frame.setVisible(true);
}}
