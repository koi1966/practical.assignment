package example.practical.assignment.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.*;
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

    @NonNull
    private String lastName;

    @NonNull
    private LocalDate born;

    private String email;

    private String Address;

    private String phone;
}