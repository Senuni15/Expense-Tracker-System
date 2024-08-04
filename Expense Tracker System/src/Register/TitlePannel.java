package Register;

import javax.swing.*;
import java.awt.*;

public class TitlePannel extends  JPanel
{
    private JLabel title;


    public TitlePannel() {
        this.title = new JLabel();

        setLayout(new BorderLayout());
        initializeTitleBarUI();

    }

    private void initializeTitleBarUI() {
        JPanel coloredPanel = new JPanel();
        title.setText("Expense Tracker System");
        coloredPanel.setBackground(new Color(180, 123, 132));;
        coloredPanel.add(title);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        //Empty panel one
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(),15));

        //Empty panel two
        JPanel emptyPanel1= new JPanel();
        emptyPanel1.setPreferredSize(new Dimension(getWidth(),15));




        add(coloredPanel,BorderLayout.CENTER);
        add(emptyPanel,BorderLayout.SOUTH);

    }

}
