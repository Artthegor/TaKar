package takar.dataManagementServices;

import takar.model.Client;
import java.util.Date;

public interface IClientManagement {
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
                               String pays
    );

    public Boolean isUsernameExist(String username);
}
