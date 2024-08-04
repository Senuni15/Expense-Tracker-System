package Register;

import javax.swing.*;
import java.awt.*;

    public class InputPannel extends JPanel {

        private JTextField tusername;
        private JPasswordField tpassword;
        private JButton sigInButton, signUpButton;

        public InputPannel() {


                setLayout(null); // Using absolute positioning

                JLabel welcomeLabel = new JLabel("WELCOME");
                welcomeLabel.setBounds(575, 10, 140, 30);
                welcomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
                add(welcomeLabel);

                JLabel usernameLabel = new JLabel("Username");
                usernameLabel.setBounds(489, 107, 140, 30);
                add(usernameLabel);

                tusername = new JTextField();
                tusername.setBounds(489, 130, 259, 30);
                tusername.setName("UserNameFieldName");
                add(tusername);

                JLabel passwordLabel = new JLabel("Password");
                passwordLabel.setBounds(489, 165, 100, 30);
                add(passwordLabel);

                tpassword = new JPasswordField();
                tpassword.setBounds(489, 190, 259, 30);
                tpassword.setName("PasswordFieldName");
                add(tpassword);

                Color customColor = new Color(199, 200, 204);

                // Create buttons
                sigInButton = new JButton("LOGIN");
                sigInButton.setBounds(530, 260, 150, 30);
                sigInButton.setBackground(customColor);
                signUpButton.setForeground(Color.BLACK);
                add(sigInButton);

                signUpButton = new JButton("SIGN UP");
                signUpButton.setBounds(530, 300, 150, 30);
                signUpButton.setBackground(customColor);
                signUpButton.setForeground(Color.BLACK);
                add(signUpButton);

                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Register/icon/budget.jpg"));
                Image image = imageIcon.getImage().getScaledInstance(450, 550, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(image);
                JLabel imgLabel = new JLabel(scaledIcon);
                imgLabel.setBounds(8, 0, 450, 550);
                add(imgLabel);


        }
    }

