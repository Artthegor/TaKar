package takar.alert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import takar.model.Client;
import takar.model.Vehicle;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class AlertMail implements IAlertMessenger {

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendMessage(String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("ncourvoisier@gmail.com");
        mail.setSubject("test");
        mail.setText(message);
        emailSender.send(mail);
    }

    @Override
    public void sendRegistration(String emailTo, String username) {
        emailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws MessagingException {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setFrom("noreply@takar.com");
                message.setTo(emailTo);
                message.setSubject("Inscription chez Takar");
                message.setText(
                        "<html>" +
                            "<head>\n" +
                            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"/>\n" +
                            "</head>" +
                            "<body><div style=\"text-align:center;\">" +
                            "<div>Bonjour " + username + ",</div></br>" +
                            "<div>Bienvenue sur Takar et merci d'avoir rejoint notre plateforme !</div>" +
                            "<div>Nous avons créé Takar dans le but de vous permettre de proposer votre véhicule à la location et louer les véhicules d'autres particuliers.</div>" +
                            "<div>Bonne navigation sur notre plateforme.</div></br>" +
                            "<div><a href=\"https://www.localhost:8080\" class=\"btn btn-dark\">Commencer</a></div></br>" +
                            "<div>A bientôt, l'équipe Takar,</div>" +
                            "<div>Un problème avec Takar ? Contactez-nous : <a href=\"mailto:contact@takar.com\">contact@takar.com</a></div>" +
                            "</div></body></html>"
                        , true);
            }
        });
    }

    @Override
    public void sendRent(String emailTo, String username) {
        emailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws MessagingException {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setFrom("noreply@takar.com");
                message.setTo(emailTo);
                message.setSubject("Ajout de votre véhicule en location sur Takar");
                message.setText(
                        "<html>" +
                                "<head>\n" +
                                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"/>\n" +
                                "</head>" +
                                "<body><div style=\"text-align:center;\">" +
                                "<div>Bonjour " + username + ",</div></br>" +
                                "<div>Votre véhicule a bien été ajouté sur Takar !</div>" +
                                "<div>Il est maintenant disponible à la location.</div></br>" +
                                "<div>A bientôt, l'équipe Takar,</div>" +
                                "<div>Un problème avec Takar ? Contactez-nous : <a href=\"mailto:contact@takar.com\">contact@takar.com</a></div>" +
                                "</div></body></html>"
                        , true);
            }
        });
    }

    @Override
    public void sendToLocataire(Vehicle vehicle, Client loueur, Client locataire, Date start, Date end) {
        long diff = end.getTime() - start.getTime();
        int duree = (int)(diff / (1000*60*60*24));
        float price = (float) (duree * vehicle.getPrice() * 1.05);

        emailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws MessagingException {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setFrom("noreply@takar.com");
                message.setTo(loueur.getMail());
                message.setSubject("Demande de location pour un véhicule");
                message.setText(
                        "<html>" +
                                "<head>\n" +
                                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"/>\n" +
                                "</head>" +
                                "<body><div style=\"text-align:center;\">" +
                                "<div>Bonjour " + loueur.getUser().getUsername() + ",</div></br>" +
                                "<div>Nous avons bien enregistré votre demande de location pour le véhicule ! " + vehicle.getBrand() + " " + vehicle.getModel() + "</div>" +
                                "<div>Vous allez être mis en relation avec Monsieur " + locataire.getLastname() + " " + locataire.getFirstname() + ". La location sera du " + start.toString() + " jusqu'à " + end.toString() + " </div>" +
                                "<div>La durée de location est de " + duree + " jours. La location de votre véhicule va vous coûter : " + price + "€.</div></br>" +
                                "<div>Le locataire vous informe avec le message suivant : " + vehicle.getInfoForClient() + ".</div></br>" +
                                "<div>A bientôt, l'équipe Takar,</div>" +
                                "<div>Un problème avec Takar ? Contactez-nous : <a href=\"mailto:contact@takar.com\">contact@takar.com</a></div>" +
                                "</div></body></html>"
                        , true);
            }
        });
    }

    @Override
    public void sendToLoueur(Vehicle vehicle, Client loueur, Client locataire, Date start, Date end) {
        long diff = end.getTime() - start.getTime();
        int duree = (int)(diff / (1000*60*60*24));
        float price = (float) (duree * vehicle.getPrice());

        emailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws MessagingException {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setFrom("noreply@takar.com");
                message.setTo(locataire.getMail());
                message.setSubject("Demande de location de votre véhicule");
                message.setText(
                        "<html>" +
                                "<head>\n" +
                                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"/>\n" +
                                "</head>" +
                                "<body><div style=\"text-align:center;\">" +
                                "<div>Bonjour " + locataire.getUser().getUsername() + ",</div></br>" +
                                "<div>Nous avons reçu une demande location pour votre véhicule : " + vehicle.getBrand() + " " + vehicle.getModel() + "</div>" +
                                "<div>Monsieur " + loueur.getLastname() + " " + loueur.getFirstname() + " souhaite louer votre véhicule de " + start.toString() + " jusqu'à " + end.toString() + " </div>" +
                                "<div>La durée de location est de " + duree + " jours. La location de votre véhicule va vous rapporter : " + price + "€.</div></br>" +
                                "<div>A bientôt, l'équipe Takar,</div>" +
                                "<div>Un problème avec Takar ? Contactez-nous : <a href=\"mailto:contact@takar.com\">contact@takar.com</a></div>" +
                                "</div></body></html>"
                        , true);
            }
        });
    }

    @Override
    public void sendDeleteVehicle(Vehicle vehicle, Client loueur) {
        emailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws MessagingException {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setFrom("noreply@takar.com");
                message.setTo(loueur.getMail());
                message.setSubject("Suppression de la location d'un véhicule");
                message.setText(
                        "<html>" +
                                "<head>\n" +
                                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"/>\n" +
                                "</head>" +
                                "<body><div style=\"text-align:center;\">" +
                                "<div>Bonjour " + loueur.getUser().getUsername() + ",</div></br>" +
                                "<div>Nous avons bien reçu votre demande de suppresion de location pour le véhicule : " + vehicle.getBrand() + " " + vehicle.getModel() + "</div></br>" +
                                "<div>Votre véhicule a été retiré de la liste des véhicules louables de notre plateforme Takar.</div>" +
                                "<div>N'hésitez pas à revenir sur notre application et de louer à nouveau votre véhicule.</div></br>" +
                                "<div>A bientôt, l'équipe Takar,</div>" +
                                "<div>Un problème avec Takar ? Contactez-nous : <a href=\"mailto:contact@takar.com\">contact@takar.com</a></div>" +
                                "</div></body></html>"
                        , true);
            }
        });
    }
}
