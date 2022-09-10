package example.practical.assignment.servise;

import example.practical.assignment.models.Users;
import example.practical.assignment.models.repo.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public record ServiceUsers(UsersRepository usersRepository) {

    public List<Users> usersList(int age) {
        return usersRepository.findByUserAge(age);
    }

    public Users AddUsers(Users users) {
        log.info("User add: {} ", users);
        return usersRepository.save(users);
    }

    public boolean DeleteUsers(Long id) {
        log.info("User delete on : {} ", id);
        usersRepository.deleteById(id);
        return null;
    }


}

//public record ServiceUsers(UsersRepository usersRepository) {
//
//    public List<Users> userList(int age) {
//        return usersRepository.findByUserAge(age);
//    }


