package misha.molotov.spring.PorjectBoot.service;

import java.util.List;


import misha.molotov.spring.PorjectBoot.dao.UserDao;
import misha.molotov.spring.PorjectBoot.model.User;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {
    public UserDao userDao;


    @Autowired
    public void UserServicelmpl(UserDao userDao) {

        this.userDao = userDao;
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void removeUser(Integer id) {
        userDao.removeUser(id);
    }

    @Transactional
    @Override
    public void updateUser(Integer id, User updateUser) {
        userDao.updateUser(id, updateUser);
    }
}