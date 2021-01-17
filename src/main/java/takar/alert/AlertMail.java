package takar.alert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

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
                message.setTo("ncourvoisier@gmail.com");
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
                message.setTo("ncourvoisier@gmail.com");
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
}
