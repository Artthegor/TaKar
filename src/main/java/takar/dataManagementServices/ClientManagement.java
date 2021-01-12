package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takar.model.Client;
import takar.repositories.ClientRepository;

@Service
public class ClientManagement implements IClientManagement {

    @Autowired
    ClientRepository clientRepo;

    public ClientManagement() {
    }

    public Client registerUser(String name,
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
        Client cli = registerUser(name, lastname,  password, sexe,
                mail, telephone, adresse, ville, departement, cp, pays);
        return clientRepo.save(cli);
    }
}
