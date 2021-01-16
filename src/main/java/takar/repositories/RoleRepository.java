package takar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import takar.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
