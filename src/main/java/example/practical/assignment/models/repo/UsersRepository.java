package example.practical.assignment.models.repo;

import example.practical.assignment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

//    @Query(nativeQuery = true,
//            value = "SELECT * FROM user WHERE age >= :age")
//    List<User> findByUserAge(@Param("age") long age);

}
