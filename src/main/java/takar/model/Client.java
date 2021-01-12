package takar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Client extends User {

    /*@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long clientID;*/

    String username;
    String firstname;
    String lastname;
    String password;
    String sexe;
    String mail;
    String telephone;
    String adresse;
    String ville;
    String departement;
    String cp;
    String pays;

    String description;

    //Date anniversaire;

    public Client(){}


    public Client(String username, String firstname, String lastname, String password, String sexe, String mail, String telephone, String adresse, String ville, String departement, String cp, String pays, String description) {
        //, Date birthday
        super(username, password);
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.sexe = sexe;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.ville = ville;
        this.departement = departement;
        this.cp = cp;
        this.pays = pays;

        this.description = description;

        //this.anniversaire = anniversaire;
    }

    public Client(String username, String firstname, String lastname, String password, String sexe, String mail, String telephone, String adresse, String ville, String departement, String cp, String pays) {
        //this(username, password, name, firstname, sex, "", mail, phoneNumber, birthday);
        this(username, firstname, lastname, password, sexe, mail, telephone, adresse, ville, departement, cp, pays, "");
    }

    /*public Date getBirthday() {
        return birthday;
    }*/

    @Override
    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String getPassword() {
        return password;
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

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
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
