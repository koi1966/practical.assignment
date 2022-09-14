package example.practical.assignment.mapper;

import example.practical.assignment.models.User;
import example.practical.assignment.models.dto.UserDto;

import java.util.List;

@org.mapstruct.Mapper
public interface Mapper {
    UsersDto usersToUsersDto(User user);
    User usersDtoToUsers(UsersDto usersDTO);
    List<UsersDto> map(List<User> userList);
}
