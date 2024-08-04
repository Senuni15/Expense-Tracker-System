package CategoryList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CategoryScreen extends JFrame
{
    private JPanel titleBar;
    private JPanel subtitleBar;
    private Inputpanel inputPanel;
    private JPanel tablePanel;

    private JTable dataTable; // Use JTable for displaying data


    private JButton addCategory, deletebtn, updatebtn;
    private DatabaseUpdateOpeContact databaseOperation; // Declare databaseOperation variable


    // Dummy data for demonstration

    public CategoryScreen() throws HeadlessException {
        this("Category List Application");

    }

    public CategoryScreen(String title) throws HeadlessException {
        super(title);

        titleBar = new TitlePanel(new JLabel(title));
        inputPanel = new Inputpanel();
        tablePanel = new JPanel(); // Placeholder, replace with your actual tablePanel initialization
        tablePanel = new DataBaseTabelPannel(); // Uncomment this line if you have a DataBaseTabelPannel class



        addCategory = new JButton("Add Category");
        deletebtn = new JButton("Delete");
        updatebtn = new JButton("Update");

        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(titleBar, BorderLayout.NORTH);

        inputPanel.setPreferredSize(new Dimension(500, 600));
        container.add(inputPanel, BorderLayout.WEST);

        JPanel inputAndTablePanel = new JPanel(new BorderLayout());
        inputAndTablePanel.add(tablePanel, BorderLayout.CENTER);
        container.add(inputAndTablePanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(addCategory);
        btnPanel.add(deletebtn);
        btnPanel.add(updatebtn);
        container.add(btnPanel, BorderLayout.SOUTH);

        addCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action listener functionality
                JTextField CategorylistTextField = new JTextField();
                JTextField DateTextField = new JTextField();
                JComboBox<String> StatusComboBox = inputPanel.getStatusComboBox();
                JTextField DescriptionTextField = new JTextField();

                String selectedStatus = (String) inputPanel.getStatusComboBox().getSelectedItem();

                Component[] components = inputPanel.getComponents();
                for (Component cmp : components) {
                    if (cmp instanceof JTextField && cmp.getName().equals("CategoryfeildName")) {
                        CategorylistTextField = (JTextField) cmp;
                    } else if (cmp instanceof JTextField && cmp.getName().equals("DatefeildName")) {
                        DateTextField = (JTextField) cmp;
                    } else if (cmp instanceof JComboBox && cmp.getName().equals("StatusComboBox")) {
                        StatusComboBox = (JComboBox<String>) cmp;
                    } else if (cmp instanceof JTextField && cmp.getName().equals("DescriptionfeildName")) {
                        DescriptionTextField = (JTextField) cmp;
                    }
                }

                if (CategorylistTextField.getText().isEmpty() || DateTextField.getText().isEmpty() || StatusComboBox.getSelectedItem() == null || DescriptionTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(btnPanel, "All fields must be filled");
                } else {
                    try {
                        String Categorylist = CategorylistTextField.getText().trim();
                        String Date = DateTextField.getText().trim();
                        String Description = DescriptionTextField.getText().trim();

                        DatabaseOpetationContacts databaseOperationsContacts = new DatabaseOpetationContacts();
                        databaseOperationsContacts.addContact(Categorylist, Date, selectedStatus, Description);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        updatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField CategorylistTextField = new JTextField();
                JTextField DateTextField = new JTextField();
                JComboBox<String> StatusComboBox = inputPanel.getStatusComboBox();
                JTextField DescriptionTextField = new JTextField();

                String selectedStatus = (String) inputPanel.getStatusComboBox().getSelectedItem();
                String categoryId = JOptionPane.showInputDialog("Enter the ID of the category to update:");

                Component[] components = inputPanel.getComponents();
                for (Component cmp : components) {
                    if (cmp instanceof JTextField && cmp.getName().equals("CategoryfeildName")) {
                        CategorylistTextField = (JTextField) cmp;
                    } else if (cmp instanceof JTextField && cmp.getName().equals("DatefeildName")) {
                        DateTextField = (JTextField) cmp;
                    } else if (cmp instanceof JTextField && cmp.getName().equals("DescriptionfeildName")) {
                        DescriptionTextField = (JTextField) cmp;
                    }
                }

                if (CategorylistTextField.getText().isEmpty() || DateTextField.getText().isEmpty()
                        || DescriptionTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(btnPanel, "All fields must be filled");
                } else {
                    try {
                        String Categorylist = CategorylistTextField.getText().trim();
                        String DateStr = DateTextField.getText().trim();
                        String Description = DescriptionTextField.getText().trim();

                        SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                        // Rename the Date variable to avoid conflict with java.util.Date
                        Date parsedDate = inputDateFormat.parse(DateStr);
                        String formattedDate = outputDateFormat.format(parsedDate); // Use String instead of Date

                        DatabaseUpdateOpeContact databaseOperationContacts = new DatabaseUpdateOpeContact();
                        databaseOperationContacts.updateContact(categoryId, Categorylist, formattedDate, selectedStatus, Description);
                    } catch (ParseException | SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(btnPanel, "Error occurred while updating category");
                    }
                }
            }
        });
        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categoryId = JOptionPane.showInputDialog("Enter the ID of the category to delete:");

                if (categoryId != null && !categoryId.isEmpty()) { // Ensure categoryId is not null or empty
                    try {
                        // Create an instance of DataBaseOperationDelete class
                        DataBaseOperationDelete databaseOperationDelete = new DataBaseOperationDelete();
                        // Call the deleteContact method to delete the category
                        databaseOperationDelete.deleteContact(categoryId);
                        // Refresh table after deletion
                        refreshTable(); // Implement this method to refresh the table data
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(btnPanel, "Error occurred while deleting category");
                    }
                }
            }
        });

        setSize(1120, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }
    private void refreshTable() {
        // Clear the existing table data
        DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
        model.setRowCount(0);
    }

    public static void main(String[] args) {
        new CategoryScreen();
    }
}

