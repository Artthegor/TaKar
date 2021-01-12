package takar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import takar.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findByUsername(String username);
}
