package takar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import takar.model.Client;
import takar.model.User;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findByUser(User user);
}
