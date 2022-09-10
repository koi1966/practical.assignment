package example.practical.assignment.models.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UsersDto {
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private LocalDate born;
    private String email;
    private String Address;
    private String phone;
}
