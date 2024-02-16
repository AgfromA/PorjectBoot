package misha.molotov.spring.PorjectBoot.dao;


import misha.molotov.spring.PorjectBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(int id, User updateUser);

    void removeUser(int id);
}