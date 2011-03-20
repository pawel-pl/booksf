package core.ejb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class Reservation implements Serializable {

    private static final long serialVersionUID = -599420769479872320L;

    @Id
    @Column(name = "RES_ID")
    @GeneratedValue
    private long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer cust;
    
    @Column(name = "TOTAL_PAID")
    private Integer totalPaid;

    public Reservation() {

    }

    public Reservation(Integer totalPaid) {

	this.totalPaid = totalPaid;
    }

    public Integer getTotalPaid() {
	return totalPaid;
    }

    public void setTotalPaid(Integer totalPaid) {
	this.totalPaid = totalPaid;
    }

    public Customer getCust() {
	return cust;
    }

    public void setCust(Customer cust) {
	this.cust = cust;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
	return "Reservation [totalPaid=" + totalPaid + "]";
    }

}
