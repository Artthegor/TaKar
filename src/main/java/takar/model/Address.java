package takar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long idadresse;
    String address, city, ZIPcode, department, country;

    public Address(String address, String city, String ZIPcode, String department, String country){
        super();
        this.address = address;
        this.city = city;
        this.country = country;
        this.department = department;
        this.ZIPcode = ZIPcode;
    }

    public Address() {
    }

    public long getIdadresse() {
        return idadresse;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDepartment() {
        return department;
    }

    public String getZIPcode() {
        return ZIPcode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setIdadresse(long idadresse) {
        this.idadresse = idadresse;
    }

    public void setZIPcode(String ZIPcode) {
        this.ZIPcode = ZIPcode;
    }
}
