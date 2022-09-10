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


}

//public record ServiceUsers(UsersRepository usersRepository) {
//
//    public List<Users> userList(int age) {
//        return usersRepository.findByUserAge(age);
//    }


