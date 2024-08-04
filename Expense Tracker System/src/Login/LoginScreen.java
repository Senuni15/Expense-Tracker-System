package Login;

import AddExpense.Tittlepanel;


import Dashboard.DashboardScreen;
import Register.RegisterScreen;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class LoginScreen  extends JFrame implements ActionListener
{
    private JTextField tusername;
    private JPasswordField tpassword;
    private JButton loginButton, signUpButton;

    public LoginScreen() {
        JLabel welcomeLabel = new JLabel("WELCOME");
        welcomeLabel.setBounds(685, 10, 140, 30);
        welcomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(welcomeLabel);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(620, 120, 140, 30);
        add(usernameLabel);

        tusername = new JTextField();
        tusername.setBounds(620, 145, 259, 30);
        add(tusername);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(620, 185, 100, 30);
        add(passwordLabel);

        tpassword = new JPasswordField();
        tpassword.setBounds(620, 210, 259, 30);
        add(tpassword);

        Color customColor = new Color(199, 200, 204);


        // Create buttons
        loginButton = new JButton("LOGIN");
        loginButton.setBounds(665, 305, 150, 30);
        loginButton.setBackground(customColor);
        loginButton.setForeground(Color.BLACK);
        loginButton.addActionListener(this);
        add(loginButton);

        signUpButton = new JButton("SIGN UP");
        signUpButton.setBounds(665, 355, 150, 30);
        signUpButton.setBackground(customColor);
        signUpButton.setForeground(Color.BLACK);
        signUpButton.addActionListener(this);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterScreen();
            }
        });
        add(signUpButton);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("Login/icon/log.png"));
        Image i2 = i1.getImage().getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(9, 10, 550, 545);
        add(img);

        setSize(955, 600);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            try {
                String username = tusername.getText();
                String password = new String(tpassword.getPassword());

                // Establish database connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbexpensetrackersystem", "root", "");

                String query = "SELECT id FROM user WHERE UName = ? AND Password = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                ResultSet resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    openDashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

                pstmt.close();
                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void openDashboard() {
        // Open the dashboard screen
        DashboardScreen dashboardScreen = DashboardScreen.createDashboardScreen();
        dashboardScreen.setVisible(true);

        // Close the login screen
        dispose();
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}






