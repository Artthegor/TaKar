package takar.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Bicycle extends Vehicle{
    String type, size;
    Boolean isElectrical;

    @OneToOne
    Vehicle vehicle;

    public Bicycle() {}

    public Bicycle(String brand, String model, int placeNumber, double price, String infoForClient, String description, int note, String type, String size, Boolean isElectrical){
        super(brand, model, placeNumber, price, infoForClient, description, note);
        this.type = type;
        this.size = size;
        this.isElectrical = isElectrical;
    }

    public Bicycle(String brand, String model, int placeNumber, double price, String infoForClient, String type, String size, Boolean isElectrical){
        this(brand, model, placeNumber, price, infoForClient, "", -1, type, size, isElectrical);
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
