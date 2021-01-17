package takar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import takar.model.Car;
import takar.model.Client;
import takar.model.User;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findByUser(User user);
    @Query(value ="from Client where user.id = :userID")
    public  Client findByid(@Param("userID")long userID);


}
