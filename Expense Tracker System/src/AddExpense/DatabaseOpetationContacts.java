package AddExpense;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatabaseOpetationContacts
{
    private Connection connection;
    private Statement statement;
    private String connectionUrl = "jdbc:mysql://localhost:3306/dbexpensetrackersystem";

    public DatabaseOpetationContacts() throws SQLException {
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

    public void addContact(String Categoryname, String Date, String Amount, String description) {
        String sql = "INSERT INTO expense (CategoryType, Date ,Amount,Description) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql.toString());

            preparedStatement.setString(1, Categoryname);
            preparedStatement.setString(3, Amount);
            preparedStatement.setString(4,description);

            // Convert the date string to MySQL date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date parsedDate = dateFormat.parse(Date);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            preparedStatement.setDate(2, sqlDate);

            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Record inserted Successfully");
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
