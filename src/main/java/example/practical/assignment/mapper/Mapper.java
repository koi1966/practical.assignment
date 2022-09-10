package example.practical.assignment.mapper;

import example.practical.assignment.models.Users;
import example.practical.assignment.models.dto.UsersDto;

import java.util.List;

@org.mapstruct.Mapper
public interface Mapper {
    UsersDto userToUserDto(Users users);

    Users userDtoToUser(UsersDto usersDTO);

    List<UsersDto> map(List<Users> usersList);
}
