package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takar.model.Client;
import takar.model.User;
import takar.repositories.ClientRepository;
import takar.repositories.UserRepository;

@Service
public class ClientManagement implements IClientManagement {

    @Autowired
    ClientRepository clientRepo;

    @Autowired
    UserRepository userRepo;

    public ClientManagement() {
    }

    public Client registerUser(String username,
                               String firstname,
                               String lastname,
                               String password,
                               //Date anniversaire,
                               String sexe,
                               String mail,
                               String telephone,
                               String adresse,
                               String ville,
                               String departement,
                               String cp,
                               String pays)
    {
        User user = new User(username, password);

        user = userRepo.save(user);
        //    public Client(String username, String password, String name, String firstname, String sex, String description, String mail, String phoneNumber) {
        Client cli = new Client(firstname, lastname,sexe, mail, telephone, adresse, ville, departement, cp, pays, user);
        /*Client cli = registerUser(name, lastname,  password, sexe,
                mail, telephone, adresse, ville, departement, cp, pays);
        */

        return clientRepo.save(cli);
    }
}