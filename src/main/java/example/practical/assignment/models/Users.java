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

    @Email
    private String email;

    private String Address;

    private String phone;

}
//1.1. Электронная почта (обязательно). Добавить проверку по шаблону электронной почты
//        1.2. Имя (обязательно)
//        1.3. фамилия (обязательно)
//        1.4. Дата рождения (обязательно). Значение должно быть раньше текущей даты
//        1.5. Адрес (необязательно)
//        1.6. Телефонный номер (не обязательно)
