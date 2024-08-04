package IncomeHistory;

import Dashboard.DashboardScreen;

import javax.swing.*;
import java.awt.*;

public class incomeHistoryscreen extends  JFrame{
    private JPanel titleBar;
    private JPanel tablePanel;


    public incomeHistoryscreen() throws HeadlessException {
        this("Income History");
    }

    public incomeHistoryscreen(String title) throws HeadlessException {
        super(title);
        titleBar = new Tittlepanel();
        tablePanel = new DatabaseTablePanel();
        InitializeUI();
    }

    private void InitializeUI() {

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Add title bar to the top
        JPanel titleBarAndInputPanel = new JPanel(new BorderLayout());
        titleBarAndInputPanel.add(titleBar, BorderLayout.NORTH);

        // Create a panel for the welcome label
        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel welcomeLabel = new JLabel("Income History");
        welcomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        welcomePanel.add(welcomeLabel);

        // Add both the title bar and the welcome label panel to the titleBarAndInputPanel
        titleBarAndInputPanel.add(welcomePanel, BorderLayout.CENTER);

        container.add(titleBarAndInputPanel, BorderLayout.NORTH);

        JPanel TableBarAndInputPanel = new JPanel();
        container.add(tablePanel, BorderLayout.CENTER);




    }

     public static incomeHistoryscreen creatIncomeHistoryScreen()
     {
         return new incomeHistoryscreen();
     }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            incomeHistoryscreen frame = new incomeHistoryscreen();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);
            frame.setVisible(true);
        });
    }
}