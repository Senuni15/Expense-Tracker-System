package ExpenseReport;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel
{
    private  JLabel title;

    public TitlePanel() { //constructor
        this.title = new JLabel();
        setLayout(new BorderLayout());
        initializeTitleBarUI();

    }
    private void initializeTitleBarUI()//UI ekata Title Bar eka intitialize karanawa
    {

        JPanel coloredPanel = new JPanel();
        title.setText("Expense Tracker System");
        coloredPanel.setBackground(new Color(208, 212, 202));
        coloredPanel.add(title);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(), 14));

        add(coloredPanel, BorderLayout.NORTH); // Add coloredPanel to the NORTH of the TitlePanel
        add(emptyPanel, BorderLayout.SOUTH); // Add emptyPanel to the SOUTH of the TitlePanel
    }

}
