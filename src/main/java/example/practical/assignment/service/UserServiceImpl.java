package example.practical.assignment.service;

import example.practical.assignment.exception.AgeException;
import example.practical.assignment.models.User;
import example.practical.assignment.models.repo.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public List<User> usersAll() {

        return usersRepository.findAll();
    }

    @Override
    public User addUsers(User user) {

        if ( user.getUserAge() < userAge ) {
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

    @Override
    public List<User> findUserBornBetween(LocalDate dateFirst, LocalDate dateLast) {
        log.info("Find all users by date first : {} on date last {}", dateFirst,dateLast);
//      List<User> userList = usersRepository.findByBornBetween(dateFirst,dateLast);
        // проверить на null
        
        return usersRepository.findByBornBetween(dateFirst,dateLast);
    }

    @Override
    public User replaceUser(long id, User input) {
        log.info("Replace user by id : {}", id);
        Optional<User> userOptional = usersRepository.findById(id);
        // проверить на null
        User user = userOptional.get();
        user.setName(input.getName());
        user.setLastName(input.getLastName());
        user.setEmail(input.getEmail());
        user.setPhone(input.getPhone());
        user.setBorn(input.getBorn());
        user.setAddress(input.getAddress());
//if
        return usersRepository.save(user);
    }

}