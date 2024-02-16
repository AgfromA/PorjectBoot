package misha.molotov.spring.PorjectBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import misha.molotov.spring.PorjectBoot.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь с id " + id + " не найден");
        } else {
            return user;
        }
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User updateUser) {
        User existingUser = entityManager.find(User.class, id);
        if (existingUser == null) {
            throw new EntityNotFoundException("Пользователь с id " + id + " не найден");
        } else {
            entityManager.merge(updateUser);
            entityManager.flush();
        }
    }

    @Override
    public void removeUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("Пользователь с id " + id + " не найден");
        } else {
            entityManager.remove(user);
        }
    }
}