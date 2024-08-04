package AddExpense;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPannel extends JPanel
{
    private JButton addExpense,deletebtn,upadatebtn;

    public ButtonPannel()
    {
        addExpense = new JButton("ADD Expense");
        deletebtn = new JButton("Delete");
        upadatebtn = new JButton("Upadate");
        InitializeUi();
    }
    private void InitializeUi()
    {
        setBackground(new Color(175, 38, 85));


        addExpense.addActionListener(new ActionListener() {//button eka clik karama enna ona de methana liyanna one
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Button Clicked");
            }
        });
        add(addExpense);
        add(deletebtn);
        add(upadatebtn);
    }
}
