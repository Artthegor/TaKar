package takar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long idLocation;
    Date beginDate, endDate;
    double totalPrice;

    public Location(Date beginDate, Date endDate, double totalPrice){
        super();
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
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
}
