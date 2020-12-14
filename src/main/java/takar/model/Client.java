package takar.model;

import java.util.Date;

public class Client extends User {
    String name, firstname, sex, description, mail, phoneNumber;
    Date birthday;

    public Client(){}

    public Client(String username, String password, String name, String firstname, String sex, String description, String mail, String phoneNumber, Date birthday) {
        super(username, password);
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.name = name;
        this.description = description;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.firstname = firstname;
        this.sex = sex;
    }

    public Client(String username, String password, String name, String firstname, String sex, String mail, String phoneNumber, Date birthday) {
        super(username, password);
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.firstname = firstname;
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getDescription() {
        return description;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
