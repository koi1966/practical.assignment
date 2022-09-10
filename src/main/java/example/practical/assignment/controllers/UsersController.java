package example.practical.assignment.controllers;

import example.practical.assignment.mapper.Mapper;
import example.practical.assignment.models.Users;
import example.practical.assignment.models.dto.UsersDto;
import example.practical.assignment.servise.ServiceUsers;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UsersController {

    private final ServiceUsers serviceUsers;

    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    public UsersController(ServiceUsers serviceUsers) {
        this.serviceUsers = serviceUsers;
    }

    //  2.1. Create user. It allows to register users who are more than [18] years old.
//       The value [18] should be taken from properties file.
    @PostMapping(value = "/add")
    public UsersDto saveUsers(@RequestBody UsersDto dto) {
//
//        Users user = mapper.usersDtoToUsers(dto);
//
//        Users saved = serviceUser.AddUsers(user);
//        log.info("UserDto: {}, saved user: {}", dto, saved);

        return null; //mapper.usersToUsersDto(saved);
    }

//    2.2. Edit user
    @PostMapping(value = "/edit")
    public UsersDto editUsers(@RequestBody UsersDto dto) {

//        Users user = mapper.usersDtoToUsers(dto);
//
//        Users saved = serviceUser.AddUsers(user);
//        log.info("UserDto: {}, saved user: {}", dto, saved);

        return null;
    }

//    2.3. Replace user
@PostMapping(value = "/replace")
public UsersDto replaceUsers(@RequestBody UsersDto dto) {

//        Users user = mapper.usersDtoToUsers(dto);
//
//        Users saved = serviceUser.AddUsers(user);
//        log.info("UserDto: {}, saved user: {}", dto, saved);

    return null;
}
//2.4. Delete user
@PostMapping(value = "/replace")
public UsersDto deleteUsers(@RequestBody UsersDto dto) {

//        Users user = mapper.usersDtoToUsers(dto);
//
//        Users saved = serviceUser.AddUsers(user);
//        log.info("UserDto: {}, saved user: {}", dto, saved);

    return null;
}

//2.5. Search for users by birth date range. Add the validation which checks
//    that “From” is less than “To”. Should return a list of objects

    @GetMapping("/age")
    public List<UsersDto> searchUser(@RequestParam int age) {
        log.info("All users age > {}", age);
        List<Users> users = serviceUsers.usersList(age);
        return null; //mapper.map(users);
    }
}
