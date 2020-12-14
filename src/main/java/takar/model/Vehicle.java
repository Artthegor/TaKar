package takar.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long IdVehicle;
    int note, placeNumber;
    String brand, model, description, infoForClient;
    double price;

    public Vehicle(){}

    public Vehicle(String brand, String model, int placeNumber, double price, String infoForClient, String description, int note){
        super();
        this.brand = brand;
        this.description = description;
        this.infoForClient = infoForClient;
        this.model = model;
        this.note = note;
        this.placeNumber = placeNumber;
        this.price = price;
    }

    public Vehicle(String brand, String model, int placeNumber, double price, String infoForClient){
        this( brand,  model,  placeNumber,  price, infoForClient, "", -1);
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getNote() {
        return note;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public long getIdVehicle() {
        return IdVehicle;
    }

    public String getBrand() {
        return brand;
    }

    public String getInfoForClient() {
        return infoForClient;
    }

    public String getModel() {
        return model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
	
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setIdVehicle(long idVehicle) {
        IdVehicle = idVehicle;
    }

    public void setInfoForClient(String infoForClient) {
        this.infoForClient = infoForClient;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public void setNote(int note) {
        this.note = note;
    }

}
