package org.example.lesson35.crud;

import org.example.lesson35.util.PostgresUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for updating field values in the database
 * It uses the "PostgresUtil" class to connect to the database.
 */
public class UpdateUser {

    /**
     * Changes the user login in the database.
     */
    public void updateUser(int id, String email, String newLogin) throws SQLException {
        PostgresUtil postgresUtil = PostgresUtil.getInstance();
        Connection connection = PostgresUtil.getConnection();
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = null;

        String sqlQuery = "UPDATE users SET login = ? WHERE id = ? AND email = ?";

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, newLogin);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
            System.out.println("Exception!!!");

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            connection.setAutoCommit(true);
            connection.close();
        }
    }
}
