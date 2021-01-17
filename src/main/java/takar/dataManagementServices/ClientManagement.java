package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import takar.model.Address;
import takar.model.Client;
import takar.model.Role;
import takar.model.User;
import takar.repositories.AddressRepository;
import takar.repositories.ClientRepository;
import takar.repositories.RoleRepository;
import takar.repositories.UserRepository;

@Service
public class ClientManagement implements IClientManagement {

    @Autowired
    ClientRepository clientRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    @Autowired
    AddressRepository addressRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ClientManagement() {
    }

    public Client registerUser(String username,
                               String firstname,
                               String lastname,
                               String password,
                               String sexe,
                               String mail,
                               String telephone,
                               String adresse,
                               String ville,
                               String departement,
                               String cp,
                               String pays)
    {
        if(userRepo.findByUsername(username) != null){
            //username déjà utilisé
            return null;
        }
        Role role = new Role("ROLE_USER");
        role = roleRepo.save(role);


        User user = new User(username, passwordEncoder.encode(password), role);
        user = userRepo.save(user);

        Address address = new Address(adresse, ville, pays, departement, cp);
        address = addressRepo.save(address);

        Client cli = new Client(firstname, lastname,sexe, mail, telephone, address, user);

        return clientRepo.save(cli);
    }
}