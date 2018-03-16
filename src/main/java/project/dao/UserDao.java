package project.dao;



import project.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User book);

    public void updateUser(User book);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> listUsers();
}
