package takar.model;

import javax.persistence.*;

@Entity
public class Bicycle extends Vehicle{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long IdVehicle;
    String type, size;
    Boolean isElectrical;



    @OneToOne
    Vehicle vehicle;

    public Bicycle() {}

    public Bicycle(String brand, String model, double price, String infoForClient, String description, int note, String type, String size, Boolean isElectrical, Vehicle vehicle){
        super(brand, model, price, infoForClient, description, note);
        this.type = type;
        this.size = size;
        this.isElectrical = isElectrical;
        this.vehicle = vehicle;
    }

    public Bicycle(String brand, String model, double price, String infoForClient, String type, String size, Boolean isElectrical, Vehicle vehicle){
        this(brand, model, price, infoForClient, "", -1, type, size, isElectrical, vehicle);
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
}
