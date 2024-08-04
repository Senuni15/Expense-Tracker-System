package Dashboard;

import AddExpense.AddExpenseScreen;
import IncomeHistory.incomeHistoryscreen;
import AddIncome.IncomeScreen;
import CategoryList.CategoryScreen;
import ExpenseReport.ExReportScreen;
import Login.LoginScreen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DashboardScreen extends JFrame {

    DashboardScreen() {
        try {
            ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("Dashboard/icon/payroll.png"));
            Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel img = new JLabel(i3);
            img.setBounds(0, 0, 1120, 630);
            add(img);

            JLabel headings = new JLabel("Expense Tracker System");
            headings.setBounds(340,10,400,40);
            headings.setFont(new Font("Raleway",Font.BOLD,30));
            img.add(headings);


            JButton  addCategory = new JButton("Category");
            addCategory.setBounds(50, 100, 150, 40);
            Color customColor = new Color(110, 32, 70, 250);
            addCategory.setBackground(customColor); // Change background color for addExpense
            addCategory.setForeground(Color.WHITE);// Change text color for addExpense
            addCategory.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CategoryScreen categoryScreen = new CategoryScreen();

                }
            });
            img.add(addCategory);

            JButton addIncome = new JButton("Income");
            addIncome.setBounds(50, 200, 150, 40);
            Color customColor2 = new Color(117, 43, 79, 250);
            addIncome.setBackground(customColor2); // Change background color for addIncome
            addIncome.setForeground(Color.WHITE);// Change text color for addIncome
            addIncome.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    IncomeScreen incomeScreen = new IncomeScreen();
                }
            });
            img.add(addIncome);

            JButton addExpense = new JButton("Expense");
            addExpense.setBounds(50, 300, 150, 40);
            Color customColor3 = new Color(110, 32, 70, 250);
            addExpense.setBackground(customColor3); // Change background color for addExpense
            addExpense.setForeground(Color.WHITE);// Change text color for addExpense
            addExpense.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddExpenseScreen addExpenseScreen =  new AddExpenseScreen();

                }
            });
            img.add(addExpense);

          incomeHistoryscreen incomeHistoryscreen = new incomeHistoryscreen();
            JButton IncomeHistory = new JButton("Income History");
            IncomeHistory.setBounds(400, 200, 150, 80);
            Color customColor4 = new Color(110, 32, 70, 250);
            IncomeHistory.setBackground(customColor4); // Change background color for IncomeHistory
            IncomeHistory.setForeground(Color.WHITE);// Change text color for IncomeHistory
            IncomeHistory.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    incomeHistoryscreen.setVisible(true); // Display the incomeHistoryscreen
                }
            });
            img.add(IncomeHistory);


            ExReportScreen exReportScreen = new ExReportScreen();
            JButton Exreport = new JButton("Expense Report");
            Exreport.setBounds(700, 200, 150, 80);
            Color customColor5 = new Color(110, 32, 70, 250);
            Exreport.setBackground(customColor5); // Change background color for Exreport
            Exreport.setForeground(Color.WHITE);// Change text color for Exreport
            Exreport.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exReportScreen.setVisible(true);
                }
            });

            img.add(Exreport);



            JButton signout = new JButton("SIGN OUT");
            signout.setBounds(50, 500, 150, 40);
            Color customColor6 = new Color(110, 32, 70, 250);
            signout.setBackground(customColor6); // Change background color for signout
            signout.setForeground(Color.WHITE); // Change text color for signout
            signout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LoginScreen loginScreen = new LoginScreen();
                }
            });

            img.add(signout);






        } catch (Exception ex) {
            ex.printStackTrace();
        }



        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }
    public static DashboardScreen createDashboardScreen() {
        return new DashboardScreen();
    }

    public static void main(String[] args) {
       DashboardScreen dashboardScreen = DashboardScreen.createDashboardScreen();
    }
}