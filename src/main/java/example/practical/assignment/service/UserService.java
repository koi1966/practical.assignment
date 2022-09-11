package example.practical.assignment.service;

import example.practical.assignment.models.User;

import java.util.List;

public interface UserService {
    List<User> usersList(int age);

    User addUsers(User user);

    User deleteUsers(Long id);
}
