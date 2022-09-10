package example.practical.assignment.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UsersController {

    @PostMapping(value = "/add")
    public UserDTO saveUser(@RequestBody UserDTO dto) {

        User user = mapper.userDtoToUser(dto);

        User saved = serviceUser.AddUsers(user);
        log.info("UserDto: {}, saved user: {}", dto, saved);

        return mapper.userToUserDto(saved);
    }

}
