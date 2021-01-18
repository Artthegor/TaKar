package takar.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long idLocation;

    @OneToOne
    Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    Date beginDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    Date endDate;

    double totalPrice;

    public Location(Date beginDate, Date endDate, double totalPrice, Vehicle vehicle, User user){
        super();
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.vehicle = vehicle;
        this.user = user;
    }

    public Location() {}

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setIdLocation(long idLocation) {
        this.idLocation = idLocation;
    }
    public long getIdLocation() {
        return idLocation;
    }

    public long getIdVehicle(){
        return vehicle.getIdVehicle();
    }
}
