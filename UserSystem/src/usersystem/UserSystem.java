package usersystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public  abstract class UserSystem implements ActionListener{
    public static void main(String[] args) {
  
 JFrame reg_frame= new JFrame();
 reg_frame.setTitle("Register");
 reg_frame.setSize(300, 300);
 reg_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 JLabel reg_username=new JLabel("Enter your username:");
 JTextField reg_user=new JTextField(10);
 JLabel reg_password=new JLabel("Enter your password:");
 JPasswordField reg_pass= new JPasswordField(10);
 JButton reg_btn=new JButton("Sign Up");
 JPanel reg_panel= new JPanel();
 reg_panel.add(reg_username);
 reg_panel.add(reg_user);
 reg_panel.add(reg_password);
 reg_panel.add(reg_pass);
 reg_panel.add(reg_btn);
 reg_frame.add(reg_panel);
 JLabel user_status=new JLabel();
 user_status.setVisible(false);
 ArrayList<String> registered = new ArrayList<>();
 reg_btn.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent arg0) {
         String user_str=reg_user.toString();
         String pass_str=reg_pass.toString();
      registered.add(user_str);
      registered.add(pass_str);
      reg_panel.add(user_status);
      user_status.setVisible(true);
      user_status.setText("You are successfuly Signed Up!");
     }
     
 });
 reg_frame.setVisible(false);
 JFrame login_frame= new JFrame();
 login_frame.setTitle("Log In");
login_frame.setSize(300, 300);
 login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 JLabel login_username=new JLabel("Enter your username:");
 JTextField login_user=new JTextField(10);
 JLabel login_password=new JLabel("Enter your password:");
 JPasswordField login_pass= new JPasswordField(10);
 JButton login_btn=new JButton("Login");
 JPanel login_panel= new JPanel();
 login_panel.add(login_username);
 login_panel.add(login_user);
 login_panel.add(login_password);
login_panel.add(login_pass);
 login_panel.add(login_btn);
 login_frame.add(login_panel);
 JFrame main_frame= new JFrame();
 main_frame.setTitle("Main Control");
 main_frame.setSize(300, 300);
 main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 JButton Sign_up_btn= new JButton("Sign Up");
 JButton Log_in_btn= new JButton("Log In");
 JPanel main_panel= new JPanel();
 main_panel.add(Sign_up_btn);
 main_panel.add(Log_in_btn);
 main_frame.add(main_panel);
 Sign_up_btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
          reg_frame.getContentPane().add(BorderLayout.CENTER,reg_panel);
           reg_frame.setVisible(true);
           login_frame.setVisible(false);
      }
 });
 Log_in_btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
          reg_frame.setVisible(false);
          login_frame.getContentPane().add(BorderLayout.CENTER,login_panel);
           login_frame.setVisible(true);
      }
 });
 main_frame.getContentPane().add(BorderLayout.CENTER,main_panel);
           main_frame.setVisible(true);
 login_btn.addActionListener( new ActionListener(){
     @Override
      public void actionPerformed(ActionEvent arg0) { 
      String usr_log=login_user.toString();
      String pass_log=login_pass.toString();
if((  usr_log == null ? reg_user.toString() == null : 
usr_log.equals(reg_user.toString()))&&(pass_log == null ? reg_pass.toString() == 
null : pass_log.equals(reg_pass.toString()))){
login_panel.add(user_status);
      user_status.setVisible(true);
      user_status.setText("You are successfuly Logged In!");
}
else {
login_panel.add(user_status);
      user_status.setVisible(true);
      user_status.setText("You are not registered!");
}
      }
 });
    }
    
}

