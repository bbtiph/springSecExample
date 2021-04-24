package kz.iitu.security.service;

import kz.iitu.security.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(Long id, User user);
}
