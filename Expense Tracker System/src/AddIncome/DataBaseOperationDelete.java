package AddIncome;

import java.sql.*;

public class DataBaseOperationDelete
{
    private Connection connection;
    private Statement statement;
    private String connectionUrl = "jdbc:mysql://localhost:3306/dbexpensetrackersystem";

    public DataBaseOperationDelete() throws SQLException {
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

    public void deleteIncome(int incomeId) {
        String sql = "DELETE FROM income WHERE IncomeID = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, incomeId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Record deleted Successfully");
            } else {
                System.out.println("No records found to delete");
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
