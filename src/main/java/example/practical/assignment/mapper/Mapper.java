package example.practical.assignment.mapper;

import example.practical.assignment.models.User;
import example.practical.assignment.models.dto.UserDto;

import java.util.List;

@org.mapstruct.Mapper
public interface Mapper {

    UserDto usersToUsersDto(User user);
    User usersDtoToUsers(UserDto userDTO);
    List<UserDto> map(List<User> userList);
}
