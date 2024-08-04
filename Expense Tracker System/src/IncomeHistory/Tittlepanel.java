package IncomeHistory;

import javax.swing.*;
import java.awt.*;

public class Tittlepanel extends JPanel
{
    private JLabel title;

    public Tittlepanel() {
        this.title = new JLabel();
        setLayout(new BorderLayout());
        InitializeTitleBarUI();
    }

    private void InitializeTitleBarUI() {
        JPanel colourPanel = new JPanel();
        title.setText("Expense Tracker System");
        colourPanel.setBackground(new Color(208, 212, 202));
        colourPanel.add(title);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(), 15));

        add(colourPanel, BorderLayout.CENTER);
        add(emptyPanel, BorderLayout.SOUTH);
    }
}
