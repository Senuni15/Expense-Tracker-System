package Register;

import Dashboard.DashboardScreen;
import ExpenseReport.TitlePanel;
import Login.LoginScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton, signUpButton;

    public RegisterScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Register Screen");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); // Using absolute positioning

        JLabel welcomeLabel = new JLabel("Create Account");
        welcomeLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        welcomeLabel.setBounds(685, 10, 140, 30);
        add(welcomeLabel);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(620, 120, 140, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(620, 145, 259, 30);
        usernameField.setName("UserNameFieldName");
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(620, 185, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(620, 210, 259, 30);
        passwordField.setName("PasswordFieldName");
        add(passwordField);

        Color customColor = new Color(199, 200, 204);

        // Create buttons
        signUpButton = new JButton("SIGN UP");
        signUpButton.setBounds(665, 305, 150, 30);
        signUpButton.setBackground(customColor);
        signUpButton.setForeground(Color.BLACK);
        add(signUpButton);

        signInButton = new JButton("SIGN IN");
        signInButton.setBounds(665, 355, 150, 30);
        signInButton.setBackground(customColor);
        signInButton.setForeground(Color.BLACK);
        add(signInButton);

        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Register/icon/budgt.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imgLabel = new JLabel(scaledIcon);
        imgLabel.setBounds(9, 10, 550, 545);
        add(imgLabel);

        setVisible(true);

        setSize(955, 600);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpUser();
            }
        });

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLoginForm();
            }
        });
    }

    private void signUpUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbexpensetrackersystem", "root", "");

            String query = "INSERT INTO user (UName, Password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Registration successful");
                openLoginForm();
            } else {
                JOptionPane.showMessageDialog(null, "Registration failed");
            }

            pstmt.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void openLoginForm() {
        // Open the login form
        new LoginScreen();

        // Close the registration form
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterScreen();
            }
        });
    }
}





