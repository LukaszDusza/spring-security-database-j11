package akademia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {

  @Query(value = "select r from Role r where r.id = ?1")
  Role findRoleById(long id);
}
