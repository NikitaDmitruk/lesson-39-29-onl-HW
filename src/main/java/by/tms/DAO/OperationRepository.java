package by.tms.DAO;


import by.tms.model.Operation;

import java.util.List;

public interface OperationRepository {

    void save(Operation operation, int userId);


    List<Operation> getAllOperationsByUserId(int userId);
}
