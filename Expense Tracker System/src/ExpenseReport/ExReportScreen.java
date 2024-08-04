package ExpenseReport;

import IncomeHistory.DatabaseTablePanel;
import IncomeHistory.Tittlepanel;
import IncomeHistory.incomeHistoryscreen;

import javax.swing.*;
import java.awt.*;

public class ExReportScreen extends JFrame
{
    private JPanel titleBar;
    private JPanel tablePanel;


    public ExReportScreen() throws HeadlessException {
        this("Expense Report");
    }

    public ExReportScreen(String title) throws HeadlessException {
        super(title);
        titleBar = new TitlePanel();
        tablePanel = new DatabaseTabelPanel();
        InitializeUI();
    }

    private void InitializeUI() {


        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Add title bar to the top
        JPanel titleBarAndInputPanel = new JPanel();
        titleBarAndInputPanel.setLayout(new BorderLayout());
        titleBarAndInputPanel.add(titleBar, BorderLayout.NORTH);

        // Create a panel for the "Income History" label
        JPanel incomeHistoryLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel incomeHistoryLabel = new JLabel("Expense Report");
        incomeHistoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeHistoryLabelPanel.add(incomeHistoryLabel);

        // Add both the title bar and the "Income History" label panel to the titleBarAndInputPanel
        titleBarAndInputPanel.add(incomeHistoryLabelPanel, BorderLayout.CENTER);

        container.add(titleBarAndInputPanel, BorderLayout.NORTH);

        JPanel TableBarAndInputPanel = new JPanel();
        container.add(tablePanel, BorderLayout.CENTER);


    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            ExReportScreen frame = new ExReportScreen();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);
            frame.setVisible(true);
        });
    }
}
