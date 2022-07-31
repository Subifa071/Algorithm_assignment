package GUI;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


//jung 


public class login1 {
    public static void main(String[] args) {
            //    Initializing components in swing
    JButton loginBtn;
    JLabel titleLabel;
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JCheckBox showPassword = new JCheckBox("Show Password");
    JFrame f = new JFrame("Login Panel");
    f.getContentPane().setBackground(Color.LIGHT_GRAY);
    loginBtn = new JButton("LOGIN");
    titleLabel = new JLabel("Login Panel");
    titleLabel.setFont(new Font("Serif", Font.PLAIN, 45));

//        Adding components to frame
    f.add(titleLabel).setBounds(150, 30, 3000, 100);
    f.add(userLabel).setBounds(50, 150, 100, 30);
    f.add(passwordLabel).setBounds(50, 220, 100, 30);
    f.add(userTextField).setBounds(150, 150, 150, 30);
    f.add(passwordField).setBounds(150, 220, 150, 30);
    f.add(showPassword).setBounds(150, 250, 150, 30);
    f.add(loginBtn).setBounds(50, 290, 100, 40);

    loginBtn.addActionListener(e -> {
            if(userTextField.getText().equals("Admin") || passwordField.getText().equals("Admin")){
                JOptionPane.showMessageDialog(f,"Login Successful!");
                new Dashboard();
                f.dispose();

            }
            else {
                JOptionPane.showMessageDialog(f,"Invalid Password!");
            }
        });



    showPassword.addActionListener(e -> {
        if (showPassword.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    });




    f.setLayout(null);
    f.setVisible(true);
    f.setResizable(false);
    f.setBounds(800, 200, 500, 520);
    }
}
