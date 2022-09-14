package example.practical.assignment.service;

import example.practical.assignment.exception.AgeException;
import example.practical.assignment.exception.AppException;
import example.practical.assignment.models.User;
import example.practical.assignment.models.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Value("${user.age}")
    private int userAge;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> usersAll() {

        return userRepository.findAll();
    }

    @Override
    public User addUsers(User user) {

        if ( user.getUserAge() < userAge ) {
            throw new AgeException("User under 18 years old  ");
        }
        log.info("User add: {}", user);
        return  userRepository.save(user);
    }
    @Override
    public User deleteUsers(Long id) {
        log.info("User delete on : {} ", id);
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public List<User> findUserBornBetween(LocalDate dateFirst, LocalDate dateLast) {
        log.info("Find all users by date first : {} on date last {}", dateFirst,dateLast);

        return userRepository.findByBornBetween(dateFirst,dateLast);
    }

    @Override
    public User editUser(long id, User input) {
        log.info("Replace user by id : {}", id);
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty())
        {
            throw new AppException("User not found.");
        }
        User user = userOptional.get();

        if (input.getName() != null)
        {
            user.setName(input.getName());
        }
        if   (input.getLastName() != null)
        {
            user.setLastName(input.getLastName());
        }

        if (input.getEmail() != null)
        {
            user.setEmail(input.getEmail());
        }
        if (input.getPhone() != null)
        {
            user.setPhone(input.getPhone());
        }
        if (input.getBorn() != null)
        {
            user.setBorn(input.getBorn());
        }
        if (input.getAddress() != null)
        {
            user.setPhone(input.getAddress());
        }
        return userRepository.save(user);
    }

    @Override
    public User replaceUser(long id, User input) {
        log.info("Replace user by id : {}", id);
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty())
        {
            throw new AppException("User not found.");
        }
        User user = userOptional.get();
        user.setName(input.getName());
        user.setLastName(input.getLastName());
        user.setEmail(input.getEmail());
        user.setPhone(input.getPhone());
        user.setBorn(input.getBorn());
        user.setAddress(input.getAddress());
        return userRepository.save(user);
    }

}