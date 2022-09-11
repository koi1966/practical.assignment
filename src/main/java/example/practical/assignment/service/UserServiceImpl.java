package example.practical.assignment.service;

import example.practical.assignment.models.User;
import example.practical.assignment.models.repo.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    @Value("${user.age}")
    private int userAge;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> usersList(int age) {
        return usersRepository.findByUserAge(age);
    }

    @Override
    public User addUsers(User user) {
        log.info("User add: {} ", user);
        if ( user.getUserAge() < userAge ) {
            throw new IllegalArgumentException("age");
        }

        return  usersRepository.save(user);
    }

    @Override
    public User deleteUsers(Long id) {
        log.info("User delete on : {} ", id);
//        usersRepository.deleteById(id);
        return null;
    }


}

//public record ServiceUsers(UsersRepository usersRepository) {
//
//    public List<Users> userList(int age) {
//        return usersRepository.findByUserAge(age);
//    }


