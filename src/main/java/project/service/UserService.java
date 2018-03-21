package project.service;


import project.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User book);

    public void updateUser(User book);

    public void removeUser(int id);

    public User getUserById(int id);

    public boolean getUser(User user);

    public List<User> listUsers();
}
