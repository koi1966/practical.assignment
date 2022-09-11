package example.practical.assignment.service;

import example.practical.assignment.exception.AgeException;
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
        return usersRepository.findAll();
    }
    @Override
    public User addUsers(User user) throws AgeException {

        if ( user.getUserAge() < userAge ) {
//            throw new IllegalArgumentException("age");
            throw new AgeException("User under 18 years old  ");
        }
        log.info("User add: {}", user);
        return  usersRepository.save(user);
    }
    @Override
    public User deleteUsers(Long id) {
        log.info("User delete on : {} ", id);
        usersRepository.deleteById(id);
        return null;
    }

}

