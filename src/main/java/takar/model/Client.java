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

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;


    String description;

    public Client(){
    }


    public Client(String firstname, String lastname, String sexe, String mail, String telephone, Address address, User user, String description) {
        super();
        this.user = user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sexe = sexe;
        this.mail = mail;
        this.telephone = telephone;
        this.address = address;

        this.description = description;
    }

    public Client(String firstname, String lastname,String sexe, String mail, String telephone, Address address, User user) {
        this(firstname, lastname, sexe, mail, telephone, address, user, "");
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

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUserID() {
        return userID;
    }

    public User getUser() {
        return user;
    }

    public Address getAddress() {
        return address;
    }
}
