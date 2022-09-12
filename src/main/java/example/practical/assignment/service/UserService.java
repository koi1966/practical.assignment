package example.practical.assignment.service;

import example.practical.assignment.exception.AgeException;
import example.practical.assignment.models.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    List<User> usersAll();

    User addUsers(User user) throws AgeException;

    User deleteUsers(Long id);

    List<User> findUserBornBetween(LocalDate dateFirst, LocalDate dateLast);

    User replaceUser(long id, User user);

    User editUser(long id, User user);
}
