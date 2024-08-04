package Register;
import Login.LoginScreen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class ButtonPannel  extends JPanel
    {
        private JButton SignUpbtn,SignIn;

        public ButtonPannel()
        {
            SignUpbtn= new JButton("Sign Up");
            SignIn = new JButton("Sign In");

            InitializeUi();
        }
        private void InitializeUi()
        {

            setBackground(new Color(40,50,60));

            //button eka clik karama enna ona de methana liyanna one
            SignUpbtn.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Register Successful");
                }
            });

            add(SignIn);
            add(SignUpbtn);

        }

    }


