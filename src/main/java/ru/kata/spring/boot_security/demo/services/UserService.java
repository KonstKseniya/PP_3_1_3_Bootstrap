package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    User getUserByUsername(String username);

    List<User> getAllUsersWithRole();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}