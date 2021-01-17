package takar.model;


import javax.persistence.*;


@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long idVehicle;

    int note;
    String brand, model, description, infoForClient;
    double price;

    @OneToOne
    Address address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;


    public Vehicle(){}

    public Vehicle(String brand, String model, double price, String infoForClient, String description, int note, User user){
        super();
        this.brand = brand;
        this.description = description;
        this.infoForClient = infoForClient;
        this.model = model;
        this.note = note;
        this.price = price;
        this.user = user;
    }

    public Vehicle(String brand, String model, double price, String infoForClient, User user){
        this( brand,  model,  price, infoForClient, "", -1, user);
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

    public long getIdVehicle() {
        return idVehicle;
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
        idVehicle = idVehicle;
    }

    public void setInfoForClient(String infoForClient) {
        this.infoForClient = infoForClient;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser(){ return user;}

    public void setNote(int note) {
        this.note = note;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
