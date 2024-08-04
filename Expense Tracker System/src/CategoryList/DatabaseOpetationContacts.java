package CategoryList;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.*;

public class DatabaseOpetationContacts {
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

    public void addContact(String categoryid, String date, String Status, String Description) {
        String sql = "INSERT INTO category(CategoryType,Date,Status,Description) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryid);
            preparedStatement.setString(3, Status);
            preparedStatement.setString(4, Description);


            // Convert the date string to MySQL date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date parsedDate = dateFormat.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            preparedStatement.setDate(2, sqlDate);

            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Record inserted Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

