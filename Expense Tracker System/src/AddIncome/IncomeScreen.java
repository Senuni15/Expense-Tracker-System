package AddIncome;

import CategoryList.TitlePanel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IncomeScreen extends JFrame {

    private JPanel titleBar;
    private JPanel inputPanelIncome;

    private JButton addIncome, deletebtn, updatebtn;

    public IncomeScreen() throws HeadlessException {
        this("Income List Application");
    }

    public IncomeScreen(String title) throws HeadlessException {
        super(title);
        titleBar = new TitlePanel(new JLabel(title));
        inputPanelIncome = new InputPanel(); // Income Input Panel

        addIncome = new JButton("Add Income");
        deletebtn = new JButton("Delete");
        updatebtn = new JButton("Update");

        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(titleBar, BorderLayout.NORTH);
        container.add(inputPanelIncome, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(addIncome);
        btnPanel.add(deletebtn);
        btnPanel.add(updatebtn);


        addIncome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField DateTextField = null;
                JTextField AmountTextField = null;
                JTextField SourceTextField = null;
                JTextField DescriptionTextField = null;

                // Get the components of inputPanelIncome
                Component[] components = inputPanelIncome.getComponents();
                for (Component cmp : components) {
                    if (cmp instanceof JTextField) {
                        JTextField textField = (JTextField) cmp;
                        switch (textField.getName()) {
                            case "DateFieldName":
                                DateTextField = textField;
                                break;
                            case "AmountFieldName":
                                AmountTextField = textField;
                                break;
                            case "SourceFeildName":
                                SourceTextField = textField;
                                break;
                            case "DescriptionFieldName":
                                DescriptionTextField = textField;
                                break;
                        }
                    }
                }

                // Check if any of the text fields are empty
                if (DateTextField.getText().isEmpty() || AmountTextField.getText().isEmpty() || SourceTextField.getText().isEmpty() || DescriptionTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(btnPanel, "All fields must be filled");
                } else {
                    // Print the values for verification
                    System.out.println("Date: " + DateTextField.getText());
                    System.out.println("Amount: " + AmountTextField.getText());
                    System.out.println("Source: " + SourceTextField.getText());
                    System.out.println("Description: " + DescriptionTextField.getText());

                    // You can add your database operations here
                    // Example:
                    try {
                        String date = DateTextField.getText().trim();
                        String amount = AmountTextField.getText().trim();
                        String source = SourceTextField.getText().trim();
                        String description = DescriptionTextField.getText().trim();
                        DatabaseOpetationContacts databaseOperationsContacts = new DatabaseOpetationContacts();
                        databaseOperationsContacts.addContact(date, amount, source, description);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });



        updatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField incomeIdField = null;
                JTextField dateField = null;
                JTextField amountField = null;
                JTextField sourceField = null;
                JTextField descriptionField = null;

                // Get the components of inputPanelIncome
                Component[] components = inputPanelIncome.getComponents();
                for (Component cmp : components) {
                    if (cmp instanceof JTextField) {
                        JTextField textField = (JTextField) cmp;
                        switch (textField.getName()) {
                            case "IncomeIdFieldName":
                                incomeIdField = textField;
                                break;
                            case "DateFieldName":
                                dateField = textField;
                                break;
                            case "AmountFieldName":
                                amountField = textField;
                                break;
                            case "SourceFeildName":
                                sourceField = textField;
                                break;
                            case "DescriptionFieldName":
                                descriptionField = textField;
                                break;
                        }
                    }
                }

                // Check if any of the text fields are empty
                if (incomeIdField.getText().isEmpty() || dateField.getText().isEmpty() || amountField.getText().isEmpty() || sourceField.getText().isEmpty() || descriptionField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(btnPanel, "All fields must be filled");
                } else {
                    // Print the values for verification
                    System.out.println("Income ID: " + incomeIdField.getText());
                    System.out.println("Date: " + dateField.getText());
                    System.out.println("Amount: " + amountField.getText());
                    System.out.println("Source: " + sourceField.getText());
                    System.out.println("Description: " + descriptionField.getText());

                    try {
                        int incomeId = Integer.parseInt(incomeIdField.getText().trim());
                        String date = dateField.getText().trim();
                        String amount = amountField.getText().trim();
                        String source = sourceField.getText().trim();
                        String description = descriptionField.getText().trim();

                        SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                        // Parse the input date string
                        Date parsedDate = inputDateFormat.parse(date);
                        // Format the parsed date to the desired output format
                        String formattedDate = outputDateFormat.format(parsedDate);
                        System.out.println("Formatted date: " + formattedDate);

                        // Now you can use the formatted date for your database operation
                        DataBaseUpdateOperation databaseUpdateOperation = new DataBaseUpdateOperation();
                        databaseUpdateOperation.updateIncome(incomeId, formattedDate, amount, source, description);
                    } catch (ParseException | SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String incomeIdText = JOptionPane.showInputDialog("Enter Income ID to delete:");
                if (incomeIdText != null && !incomeIdText.isEmpty()) {
                    int incomeId = Integer.parseInt(incomeIdText);
                    try {
                        DataBaseOperationDelete databaseOperationsDelete = new DataBaseOperationDelete();
                       databaseOperationsDelete.deleteIncome(incomeId);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(btnPanel, "Please enter a valid Income ID");
                }
            }
        });

        container.add(btnPanel, BorderLayout.SOUTH);

        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }







    public static void main(String[] args) {
        new IncomeScreen();
    }
}
