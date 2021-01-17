package takar.alert;

public interface IAlertMessenger {
    public void sendMessage(String message);
    public void sendRegistration(String emailTo, String username);
    public void sendRent(String emailTo, String username);
}
