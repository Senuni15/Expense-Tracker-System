package CategoryList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseTabelPannel extends JPanel
{
    private JTable table;

    public DataBaseTabelPannel() {

        setLayout(new BorderLayout());
        // Create a DefaultTableModel
        DefaultTableModel model = new DefaultTableModel();

        // Set column names
        model .setColumnIdentifiers(new Object[]{"CategoryId","CategoryType", "Date","Status","Description"});

        // Retrieve data from the database
        fetchDataFromDatabase(model);

        // Create the JTable with the DefaultTableModel
        table = new JTable(model);
        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        //Adjust the prefference size of the JScollpannel
        scrollPane.setPreferredSize(new Dimension(400,100));
        setPreferredSize(new Dimension(400, 100));

        // Add the JScrollPane to the frame
        add(scrollPane,BorderLayout.CENTER);


        // Display the frame
        setVisible(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
            Connection connection = DriverManager.getConnection(url,username,password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query to retrieve data
            ResultSet rs = statement.executeQuery("SELECT * FROM Category");

            // Iterate through the result set and add data to the model
            while (rs.next()) {
                int CategoryID;
                String Categorytype;
                String Date;
                String status;
                String Description;
                model.addRow(new Object[]{
                        CategoryID = rs.getInt("CategoryId"),
                        Categorytype = rs.getString("CategoryType"),
                        status = rs.getString("Status"),
                        Date =rs.getString("Date"),
                        Description  = rs.getString("Description"),
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
