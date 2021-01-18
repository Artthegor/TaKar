package takar.alert;

import takar.model.Client;
import takar.model.Vehicle;

import java.util.Date;

public interface IAlertMessenger {
    public void sendMessage(String message);
    public void sendRegistration(String emailTo, String username);
    public void sendRent(String emailTo, String username);
    public void sendToLocataire(Vehicle vehicle, Client loueur, Client locataire, Date start, Date end);
    public void sendToLoueur(Vehicle vehicle, Client loueur, Client locataire, Date start, Date end);
}
