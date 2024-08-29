package by.tms.DAO;

import by.tms.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public void save(User user);

    public Optional<User> getById(int id);

    public Optional <User> getByUsername(String username);

    public List<User> getAll();
}
