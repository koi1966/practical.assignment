package example.practical.assignment.models.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UsersDto {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotNull
    @PastOrPresent
    private LocalDate born;
    @Email(message = "Bad email.")
    @NotBlank(message = "Email not blank")
    private String email;
    private String address;
    private String phone;
}
