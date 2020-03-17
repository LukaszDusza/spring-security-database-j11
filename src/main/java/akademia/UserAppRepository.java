package akademia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {

  @Query(value = "select u from UserApp u where u.login = ?1") //JPQL
  Optional<UserApp> findUserByLogin(String login);
}
