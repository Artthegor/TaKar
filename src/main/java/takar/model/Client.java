package takar.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long userID;

    @OneToOne
    User user;

    String firstname;
    String lastname;
    String sexe;
    String mail;
    String telephone;
    String adresse;
    String ville;
    String departement;
    String cp;
    String pays;

    String description;

    public Client(){
    }


    public Client(String firstname, String lastname, String sexe, String mail, String telephone, String adresse, String ville, String departement, String cp, String pays, User user, String description) {
        this.user = user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sexe = sexe;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.ville = ville;
        this.departement = departement;
        this.cp = cp;
        this.pays = pays;

        this.description = description;
    }

    public Client(String firstname, String lastname,String sexe, String mail, String telephone, String adresse, String ville, String departement, String cp, String pays, User user) {
        this(firstname, lastname, sexe, mail, telephone, adresse, ville, departement, cp, pays, user, "");
    }




    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSexe() {
        return sexe;
    }

    public String getMail() {
        return mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public String getDepartement() {
        return departement;
    }

    public String getCp() {
        return cp;
    }

    public String getPays() {
        return pays;
    }

    public String getDescription() {
        return description;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
