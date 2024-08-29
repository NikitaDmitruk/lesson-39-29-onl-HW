package by.tms.DAO;


import by.tms.connection.PostgresConnection;
import by.tms.model.Operation;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OperationDao implements OperationRepository {

    @Override
    public void save(Operation operation, int userId) {
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO operations VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setDouble(1, operation.getNum1());
            preparedStatement.setDouble(2, operation.getNum2());
            preparedStatement.setString(3, operation.getType());
            preparedStatement.setDouble(4, operation.getResult());
            preparedStatement.setInt(5, userId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Operation> getAllOperationsByUserId(int userId) {
        List<Operation> operations = new ArrayList<>();
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM operations JOIN public.users u on u.id = operations.user_id WHERE user_id = ? ");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Operation operation = new Operation();
                operation.setNum1(resultSet.getDouble("num1"));
                operation.setNum2(resultSet.getDouble("num2"));
                operation.setType(resultSet.getString("type"));
                operation.setResult(resultSet.getDouble("result"));
                operations.add(operation);
            }
            return operations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operations;
    }
}
