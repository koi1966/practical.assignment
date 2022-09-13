package example.practical.assignment.models.repo;

import example.practical.assignment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

   List<User> findByBornBetween(LocalDate from, LocalDate to);
}
