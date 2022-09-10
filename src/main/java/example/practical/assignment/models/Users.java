package example.practical.assignment.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Users {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NonNull
    private String name;

//    2.1. Create user. It allows to register users who are more than [18] years old.
//    The value [18] should be taken from properties file.
    @NonNull
    private String lastName;

    @Min(18)
    private Integer age;

    @NonNull
    private LocalDate born;

    @Email
    private String email;

    private String Address;

    private String phone;
}