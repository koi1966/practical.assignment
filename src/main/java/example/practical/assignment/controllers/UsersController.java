package example.practical.assignment.controllers;

import example.practical.assignment.exception.AgeException;
import example.practical.assignment.exception.AppException;
import example.practical.assignment.mapper.Mapper;
import example.practical.assignment.models.User;
import example.practical.assignment.models.dto.UsersDto;
import example.practical.assignment.service.ErrorMessage;
import example.practical.assignment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    private final Mapper mapper = Mappers.getMapper(Mapper.class);
    public UsersController(UserService userService) {
        this.userService = userService;
    }
//    2.1. Create user. It allows to register users who are more than [18] years old.
//         The value [18] should be taken from properties file.

    @PostMapping
    public UsersDto saveUsers(@Valid @RequestBody UsersDto dto, Errors errors) {
        User user = mapper.usersDtoToUsers(dto);
        User saved = userService.addUsers(user);

        return mapper.usersToUsersDto(saved);
    }

//    2.2. Edit user
    @PutMapping()
    public UsersDto editUsers(@RequestParam long id, @RequestBody UsersDto dto) {

        User user = mapper.usersDtoToUsers(dto);

//        Users saved = serviceUser.AddUsers(user);
//        log.info("UserDto: {}, saved user: {}", dto, saved);

        return null;
    }

@DeleteMapping()
public UsersDto deleteUsers(@RequestParam long id) {
        userService.deleteUsers(id);
       log.info("User delete id: {}", id);
    return null;
}

//2.5. Search for users by birth date range. Add the validation which checks
//    that “From” is less than “To”. Should return a list of objects

    @GetMapping("/age")
    public List<UsersDto> searchUser(@RequestParam int age) {
        log.info("All users age > {}", age);
        List<User> users = userService.usersList(age);
        return mapper.map(users);
    }
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorMessage> handleException(AppException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleException(ConstraintViolationException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }

}
