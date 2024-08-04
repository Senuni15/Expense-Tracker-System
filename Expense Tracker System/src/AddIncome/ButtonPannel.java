package AddIncome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPannel extends JPanel
{
    private JButton addIncome,deletebtn,upadatebtn;

    public ButtonPannel()
    {
        addIncome = new JButton("ADD Income");
        deletebtn = new JButton("Delete");
        upadatebtn = new JButton("Upadate");
        InitializeUi();
    }
    private void InitializeUi()
    {
        setBackground(new Color(175, 38, 85));


            addIncome.addActionListener(new ActionListener() {//button eka clik karama enna ona de methana liyanna one
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Button Clicked");
            }
        });
        add(addIncome);
        add(deletebtn);
        add(upadatebtn);
    }
}
