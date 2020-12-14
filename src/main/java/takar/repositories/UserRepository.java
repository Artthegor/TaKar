package takar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import takar.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
	public User findByNomAndPrenom(String nom, String prenom);
}