package Register;

import java.sql.*;

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

    public void addContact(String name, String phoneNumber) {
        String sql = "INSERT INTO user (UName,Password) VALUES(?,?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Register Successfully");
            }

        } catch (SQLException e) {
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