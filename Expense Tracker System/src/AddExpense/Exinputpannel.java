package AddExpense;

import javax.swing.*;
import java.awt.*;

public class Exinputpannel extends JPanel
{
    private JLabel Categorytype, Date, Description,Amount,ExpenseId;
    private JTextField CategoryField, DateField, DescritiptionFeild,AmountField,ExpenseIdFeild;


    public Exinputpannel() {
        setLayout(null); // Use null layout for absolute positioning
        initializeUI();
    }

    public JTextField getCategoryField() {
        return CategoryField;
    }

    public JTextField getDateField() {
        return DateField;
    }

    public JTextField getDescritiptionFeild() {
        return DescritiptionFeild;
    }

    public JTextField getAmountField() {
        return AmountField;
    }


    private void initializeUI() {

        JLabel welcomeLabel = new JLabel("Add Expense");
        welcomeLabel.setBounds(40, 10, 200, 30);
        welcomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(welcomeLabel);

        Categorytype = new JLabel("Category type");
        Categorytype.setBounds(40, 60, 100, 30);

        Date = new JLabel("Date");
        Date.setBounds(40, 105, 100, 30);

        Amount = new JLabel("Amount");
        Amount.setBounds(40, 150, 100, 30);

        Description = new JLabel("Description");
        Description.setBounds(40, 195, 100, 30);

        ExpenseId = new JLabel("Enter income id to update");
        ExpenseId.setBounds(230,221,100,30);
        ExpenseId.setFont(new Font("Raleway", Font.BOLD, 8));

        CategoryField = new JTextField();
        CategoryField.setBounds(150, 61, 300, 25);
        CategoryField.setName("CategoryFieldName");

        DateField = new JTextField();
        DateField.setBounds(150, 106, 300, 25);
        DateField.setName("DateFieldName");

        AmountField = new JTextField();
        AmountField.setBounds(150, 151, 300, 25);
        AmountField.setName("AmountFieldName");

        DescritiptionFeild = new JTextField();
        DescritiptionFeild.setBounds(150, 196, 300, 25);
        DescritiptionFeild.setName("DescriptionFieldName");

        ExpenseIdFeild = new JTextField();
        ExpenseIdFeild.setBounds (150,245,300,25);
        ExpenseIdFeild.setName("IncomeIdFieldName");


        add(Categorytype);
        add(CategoryField);
        add(Date);
        add(DateField);
        add(Amount); // Add amount label
        add(AmountField);
        add(Description); // Add description label
        add(DescritiptionFeild);
        add(ExpenseId);
        add(ExpenseIdFeild);
    }
}
