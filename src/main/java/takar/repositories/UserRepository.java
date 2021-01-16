package takar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import takar.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}