package example.practical.assignment.controllers;

import example.practical.assignment.exception.AppException;
import example.practical.assignment.mapper.Mapper;
import example.practical.assignment.models.User;
import example.practical.assignment.models.dto.UsersDto;
import example.practical.assignment.service.ErrorMessage;
import example.practical.assignment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.time.LocalDate;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UsersDto saveUser(@Valid @RequestBody UsersDto dto) {
        User user = mapper.usersDtoToUsers(dto);
        User saved = userService.addUsers(user);

        return mapper.usersToUsersDto(saved);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping()
    public UsersDto replaceUsers(@RequestParam long id, @RequestBody UsersDto dto) {
        User user = mapper.usersDtoToUsers(dto);
        User outUser = userService.replaceUser(id,user);
        return mapper.usersToUsersDto(outUser);
    }

//    @PatchMapping()
//    public UsersDto replaceUsers(@RequestParam long id, @RequestBody UsersDto dto) {
//        User user = mapper.usersDtoToUsers(dto);
//        User outUser = userService.replaceUser(id,user);
//        return mapper.usersToUsersDto(outUser);
//    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping()
    public UsersDto deleteUser(@RequestParam long id) {
        userService.deleteUsers(id);
        log.info("User delete id: {}", id);
        return null;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<UsersDto> searchUser(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFirst, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateLast) {
        if (dateFirst.isAfter(dateLast)) {
            System.out.println(String.format("Date %s comes after %s", dateFirst, dateLast));
            throw new AppException(String.format("Date %s comes after %s", dateFirst, dateLast));
        }
        log.info("All users born firs {} and last {}", dateFirst, dateLast);
        List<User> users = userService.findUserBornBetween(dateFirst, dateLast);
        return mapper.map(users);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<UsersDto> searchAll(){
        List<User> users = userService.usersAll();
        return  mapper.map(users);
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
