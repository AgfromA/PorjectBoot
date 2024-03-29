package misha.molotov.spring.PorjectBoot.services;


import misha.molotov.spring.PorjectBoot.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(Integer id);

    public void addUser(User user);

    public void updateUser(Integer id, User updateUser);

    public void removeUser(Integer id);
}