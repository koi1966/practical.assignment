package example.practical.assignment.models.repo;

import example.practical.assignment.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    @Query(nativeQuery = true,
            value = "SELECT * FROM users WHERE age >= :age")
    List<Users> findByUserAge(@Param("age") long age);

}
