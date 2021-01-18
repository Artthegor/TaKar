package takar.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bicycle implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long IdBicycle;
    String type, size;
    Boolean isElectrical;



    @OneToOne
    Vehicle vehicle;

    public Bicycle() {}

    public Bicycle( String type, String size, Boolean isElectrical, Vehicle vehicle){
        this.type = type;
        this.size = size;
        this.isElectrical = isElectrical;
        this.vehicle = vehicle;
    }

    public Boolean getElectrical() {
        return isElectrical;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void setElectrical(Boolean electrical) {
        isElectrical = electrical;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
