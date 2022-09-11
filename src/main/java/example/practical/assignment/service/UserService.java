package example.practical.assignment.service;

import example.practical.assignment.exception.AgeException;
import example.practical.assignment.models.User;

import java.util.List;

public interface UserService {
    List<User> usersList(int age);

    User addUsers(User user) throws AgeException;

    User deleteUsers(Long id);

    User findUserDate(long id, User user);
}
