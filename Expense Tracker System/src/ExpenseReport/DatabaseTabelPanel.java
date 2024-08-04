package ExpenseReport;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTabelPanel extends JPanel
{
    private JTable table;

    public DatabaseTabelPanel() {
        setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ExpenseId","CategoryType"," Date","Amount","Description"});
        fetchDataFromDatabase(model);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void fetchDataFromDatabase(DefaultTableModel model) {
        // JDBC connection parameters
        String url = "jdbc:mysql://localhost:3306/dbexpensetrackersystem";
        String username = "root";
        String password = "";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query to retrieve data
            ResultSet rs = statement.executeQuery("SELECT * FROM expense");

            // Iterate through the result set and add data to the model
            while (rs.next()) {
                String ExpenseID;
                String CategoryType;
                String Date;
                String Amount;
                String Description;
                model.addRow(new Object[]{
                        ExpenseID = rs.getString("ExpenseId"),
                        CategoryType = rs.getString("CategoryType"),
                        Date = rs.getString("Date"),
                        Amount = rs.getString("Amount"),
                        Description = rs.getString("Description"),

                });
            }

            // Close the resources
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
