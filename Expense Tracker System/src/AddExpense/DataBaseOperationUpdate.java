package AddExpense;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataBaseOperationUpdate
{
    private Connection connection;
    private Statement statement;
    private String connectionUrl = "jdbc:mysql://localhost:3306/dbexpensetrackersystem";

    public DataBaseOperationUpdate() throws SQLException {
        connect();
    }

    private void connect() throws SQLException {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.connection = DriverManager.getConnection(connectionUrl, "root", "");
            this.statement = this.connection.createStatement();
            System.out.println("Database connected...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateExpense(int expenseId, String Categoryname, String Date, String Amount, String description) {
        String sql = "UPDATE expense SET CategoryType = ?, Date = ?, Amount = ?, Description = ? WHERE ExpenseID = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, Categoryname);
            preparedStatement.setString(4, description);
            preparedStatement.setString(3, Amount);
            preparedStatement.setInt(5, expenseId);

            // Convert the date string to MySQL date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date parsedDate = dateFormat.parse(Date);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            preparedStatement.setDate(2, sqlDate);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record updated Successfully");
            } else {
                System.out.println("No records found to update");
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
