package AddExpense;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;



    public class AddExpenseScreen extends JFrame {

        private JPanel titleBar;
        private JPanel subtitleBar;
        private JPanel inputPanelExpense;

        private JPanel btnPanel;

        private JButton addExpense, deletebtn, upadatebtn;

        public AddExpenseScreen() throws HeadlessException {
            this("Expense List Application");
        }

        public AddExpenseScreen(String title) throws HeadlessException {
            super(title);

            titleBar = new Tittlepanel();
            inputPanelExpense = new Exinputpannel();

            subtitleBar = new JPanel(); // Initialize subtitleBar

            addExpense = new JButton("Add Expense");
            deletebtn = new JButton("Delete");
            upadatebtn = new JButton("Update");

            initializeUI();
        }

        private void initializeUI() {
            Container container = getContentPane();
            container.setLayout(new BorderLayout());

            JPanel titleBarAndInputPanel = new JPanel(new BorderLayout());
            titleBarAndInputPanel.add(titleBar, BorderLayout.NORTH);
            titleBarAndInputPanel.add(inputPanelExpense, BorderLayout.CENTER);
            container.add(titleBarAndInputPanel, BorderLayout.NORTH);

            JPanel subtitleBarAndInputPanel = new JPanel(new BorderLayout());
            subtitleBarAndInputPanel.add(subtitleBar, BorderLayout.NORTH);
            subtitleBarAndInputPanel.add(inputPanelExpense, BorderLayout.CENTER);
            container.add(subtitleBarAndInputPanel, BorderLayout.CENTER);

            JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            btnPanel.add(addExpense);
            btnPanel.add(deletebtn);
            btnPanel.add(upadatebtn);
            container.add(btnPanel, BorderLayout.SOUTH);

            addExpense.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField CategorytypeTextField = new JTextField();
                    JTextField DateTextField = new JTextField();
                    JTextField AmountTextField = new JTextField();
                    JTextField DescriptionTextField = new JTextField();
                    // Set names for the text fields
                    CategorytypeTextField.setName("CategoryFieldName");
                    DateTextField.setName("DateFieldName");
                    AmountTextField.setName("AmountFieldName");
                    DescriptionTextField.setName("DescriptionFieldName");

                    //Created a component array
                    //inside this array it have 4 components (two text fields and two labels)
                    ; // Create an instance of Exinputpannel
                    Component[] components = inputPanelExpense.getComponents(); // Call getComponents() on the instance
                    for (Component cmp : components) {

                        if (cmp instanceof JTextField && cmp.getName().equals("CategoryFieldName")) {
                            CategorytypeTextField = (JTextField) cmp;
                        } else if (cmp instanceof JTextField && cmp.getName().equals("DateFieldName")) {
                            DateTextField = (JTextField) cmp;
                        } else if (cmp instanceof JTextField && cmp.getName().equals("AmountFieldName")) {
                            AmountTextField = (JTextField) cmp;
                        } else if (cmp instanceof JTextField && cmp.getName().equals("DescriptionFieldName")) {
                            DescriptionTextField = (JTextField) cmp;
                        }
                    }
                    if (CategorytypeTextField.getText().isEmpty() || DateTextField.getText().isEmpty() || AmountTextField.getText().isEmpty() || DescriptionTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(btnPanel, "All fields must be filled");
                    } else {
                        System.out.println(CategorytypeTextField.getText());
                        System.out.println(DateTextField.getText());
                        System.out.println(AmountTextField.getText());
                        System.out.println(DescriptionTextField.getText());
                        try {
                            String CategoryType = CategorytypeTextField.getText().trim();
                            String Date = DateTextField.getText().trim();
                            String Amount = AmountTextField.getText().trim();
                            String Description = DescriptionTextField.getText().trim();

                           DatabaseOpetationContacts databaseOperationsContacts = new DatabaseOpetationContacts();
                            databaseOperationsContacts.addContact(CategoryType,Date,Amount,Description);


                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });

            upadatebtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField expenseIdField = null;
                    JTextField categoryField = null;
                    JTextField dateField = null;
                    JTextField amountField = null;
                    JTextField descriptionField = null;

                    // Get the components of inputPanelExpense
                    Component[] components = inputPanelExpense.getComponents();
                    for (Component cmp : components) {
                        if (cmp instanceof JTextField) {
                            JTextField textField = (JTextField) cmp;
                            switch (textField.getName()) {
                                case "IncomeIdFieldName":
                                    expenseIdField = textField;
                                    break;
                                case "CategoryFieldName":
                                    categoryField = textField;
                                    break;
                                case "DateFieldName":
                                    dateField = textField;
                                    break;
                                case "AmountFieldName":
                                    amountField = textField;
                                    break;
                                case "DescriptionFieldName":
                                    descriptionField = textField;
                                    break;
                            }
                        }
                    }

                    // Check if any of the text fields are empty
                    if (expenseIdField.getText().isEmpty() || categoryField.getText().isEmpty() || dateField.getText().isEmpty() || amountField.getText().isEmpty() || descriptionField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(btnPanel, "All fields must be filled");
                    } else {
                        // Print the values for verification
                        System.out.println("Expense ID: " + expenseIdField.getText());
                        System.out.println("Category: " + categoryField.getText());
                        System.out.println("Date: " + dateField.getText());
                        System.out.println("Amount: " + amountField.getText());
                        System.out.println("Description: " + descriptionField.getText());

                        try {
                            int expenseId = Integer.parseInt(expenseIdField.getText().trim());
                            String category = categoryField.getText().trim();
                            String date = dateField.getText().trim();
                            String amount = amountField.getText().trim();
                            String description = descriptionField.getText().trim();

                            // Perform the update operation
                            // Note: Implement the update logic in your DatabaseOperationContacts class
                            // Similar to the addContact method, but using the updateExpense method
                          DataBaseOperationUpdate dataBaseOperationUpdate = new DataBaseOperationUpdate();
                            // Call the method to update the expense details
                            dataBaseOperationUpdate.updateExpense(expenseId, category, date, amount, description);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
            deletebtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField expenseIdField = null;

                    // Get the components of inputPanelExpense
                    Component[] components = inputPanelExpense.getComponents();
                    for (Component cmp : components) {
                        if (cmp instanceof JTextField && cmp.getName().equals("IncomeIdFieldName")) {
                            expenseIdField = (JTextField) cmp;
                            break; // Found the expense ID field, no need to iterate further
                        }
                    }

                    // Check if the expense ID field is empty
                    if (expenseIdField == null || expenseIdField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(btnPanel, "Expense ID must be filled to delete");
                    } else {
                        try {
                            int expenseId = Integer.parseInt(expenseIdField.getText().trim());

                            // Perform the delete operation
                            DatabaseOperateDelete databaseOperateDelete = new DatabaseOperateDelete();
                            // Call the method to delete the expense
                            databaseOperateDelete.deleteExpense(expenseId);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });

            setSize(600, 450);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
        }

        public static void main(String[] args) {
            new AddExpenseScreen();
        }
    }

