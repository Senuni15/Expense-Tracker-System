package AddIncome;

import java.sql.*;

public class DataBaseUpdateOperation
{
    private Connection connection;
    private Statement statement;
    private String connectionUrl = "jdbc:mysql://localhost:3306/dbexpensetrackersystem";

    public DataBaseUpdateOperation() throws SQLException {
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
    public void updateIncome(int incomeId, String date, String amount, String source, String description) {
        String sql = "UPDATE income SET Date = ?, Amount = ?, Source = ?, Description = ? WHERE IncomeID = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, amount);
            preparedStatement.setString(3, source);
            preparedStatement.setString(4, description);
            preparedStatement.setInt(5, incomeId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record updated Successfully");
            } else {
                System.out.println("No records found to update");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
