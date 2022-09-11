package example.practical.assignment.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.Period;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

//    2.1. Create user. It allows to register users who are more than [18] years old.
//    The value [18] should be taken from properties file.
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate born;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    private String address;

    private String phone;

    public int getUserAge() {

        return Period.between(born, LocalDate.now()).getYears();
    }
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", born=" + born +
                ", email='" + email + '\'' +
                ", Address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}