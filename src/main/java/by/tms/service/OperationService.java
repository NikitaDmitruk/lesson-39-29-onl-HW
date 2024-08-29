package by.tms.service;


import by.tms.DAO.OperationDao;
import by.tms.DAO.OperationRepository;
import by.tms.model.Operation;
import by.tms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationDao operationDao;

    public OperationService(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public Operation execute(Operation operation, int userId) {
        switch (operation.getType()) {
            case "SUM":
                operation.setResult(operation.getNum1() + operation.getNum2());
                operationDao.save(operation, userId);
                return operation;
            case "SUB":
                operation.setResult(operation.getNum1() - operation.getNum2());
                operationDao.save(operation, userId);
                return operation;
            case "MUL":
                operation.setResult(operation.getNum1() * operation.getNum2());
                operationDao.save(operation, userId);
                return operation;
            case "DIV":
                operation.setResult(operation.getNum1() / operation.getNum2());
                operationDao.save(operation, userId);
                return operation;
        }
        throw new IllegalArgumentException("by.tms.lesson25.calculator.model.Operation type not supported");
    }

    public List<Operation> findAll(int userId) {
        return operationDao.getAllOperationsByUserId(userId);
    }
}
