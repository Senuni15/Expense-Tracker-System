package AddIncome;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private JLabel Date, Amount, Source, Description,incomeId;
    private JTextField DateField, AmountField, SourceField, DescriptionField,incomeIdField;

    public InputPanel() {
        setLayout(null); // Use null layout for absolute positioning
        initializeUI();
    }

    private void initializeUI() {
        JLabel welcomeLabel = new JLabel("Add Income");
        welcomeLabel.setBounds(40, 10, 140, 30);
        welcomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(welcomeLabel);

        Date = new JLabel("Date");
        Date.setBounds(40, 60, 100, 30);

        Amount = new JLabel("Amount");
        Amount.setBounds(40, 100, 100, 30);

        Source = new JLabel("Source");
        Source.setBounds(40, 140, 100, 30);

        Description = new JLabel("Description");
        Description.setBounds(40, 180, 100, 30);

        incomeId = new JLabel("Enter income id to update");
        incomeId.setBounds(230,221,100,30);
        incomeId.setFont(new Font("Raleway", Font.BOLD, 8));

        DateField = new JTextField();
        DateField.setBounds(150, 60, 300, 25);
        DateField.setName("DateFieldName");

        AmountField = new JTextField();
        AmountField.setBounds(150, 100, 300, 25);
        AmountField.setName("AmountFieldName");

        SourceField = new JTextField();
        SourceField.setBounds(150, 140, 300, 25);
        SourceField.setName("SourceFeildName");

        DescriptionField = new JTextField();
        DescriptionField.setBounds(150, 180, 300, 25);
        DescriptionField.setName("DescriptionFieldName");

        incomeIdField = new JTextField();
        incomeIdField.setBounds(150,245,300,25);
        incomeIdField.setName("IncomeIdFieldName");

        add(Date);
        add(DateField);
        add(Amount);
        add(AmountField);
        add(Source);
        add(SourceField);
        add(Description);
        add(DescriptionField);
        add(incomeId);
        add(incomeIdField);
    }

    public JTextField getDateField() {
        return DateField;
    }

    public JTextField getAmountField() {
        return AmountField;
    }

    public JTextField getSourceField() {
        return SourceField;
    }

    public JTextField getDescriptionField() {
        return DescriptionField;
    }


}
