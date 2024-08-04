package CategoryList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPannel extends JPanel
{
    private JButton addCategory,deletebtn,upadatebtn;

    public ButtonPannel()
    {
        addCategory = new JButton("ADD");
        deletebtn = new JButton("Delete");
        upadatebtn = new JButton("Upadate");
        InitializeUi();
    }
    private void InitializeUi()
    {
        setBackground(new Color(175, 38, 85));


        addCategory.addActionListener(new ActionListener() {//button eka clik karama enna ona de methana liyanna one
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Button Clicked");
            }
        });

        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Button Clicked");
            }
        });

        upadatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Update Button Clicked");
            }
        });
        add(addCategory);
        add(deletebtn);
        add(upadatebtn);
    }
}
