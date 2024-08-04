package CategoryList;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DatabaseUpdateOpeContact {
    private Connection connection;
    private Statement statement;
    private String connectionUrl = "jdbc:mysql://localhost:3306/dbexpensetrackersystem";

    public DatabaseUpdateOpeContact() throws SQLException {
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

    public void updateContact(String categoryId, String categoryType, String date, String status, String description) {
        String sql = "UPDATE category SET CategoryType = ?, Date = ?, Status = ?, Description = ? WHERE CategoryID = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryType);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, status);
            preparedStatement.setString(4, description);
            preparedStatement.setString(5, categoryId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully");
            } else {
                System.out.println("No record found for ID: " + categoryId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


