package core.ejb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
@SqlResultSetMapping(name = "customerMapping", 
	entities = {@EntityResult(entityClass = Customer.class), @EntityResult(entityClass = CreditCard.class)}
				/*fields={@FieldResult(name="address.city", column="city"),
	    				@FieldResult(name="address.street", column="street"),
	    				@FieldResult(name="address.houseNo", column="houseNo"),
	    				@FieldResult(name="id", column="CUST_ID")}) },*/
	)
@NamedNativeQuery(name = "findAllCustomers", query = "select c.*, count(r.total_paid) as tp from CUSTOMER c left join c.reservations r", resultSetMapping = "customerMapping")
public class Customer implements java.io.Serializable {

    private static final long serialVersionUID = 6183762871766312590L;

    @Id
    @Column(name = "CUST_ID")
    @GeneratedValue
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Embedded
    private Address address;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "card_id")
    private CreditCard card;

    @OneToMany(mappedBy = "cust", cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<Reservation>();

    public Customer() {

    }

    public Customer(String firstName, String lastName, Address address,
	    Set<Reservation> reservations, CreditCard card) {

	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.card = card;
	this.reservations = reservations;
	for (Reservation res : reservations) {
	    res.setCust(this);
	}
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String last) {
	this.lastName = last;
    }

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }

    public Set<Reservation> getReservations() {
	return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
	this.reservations = reservations;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CreditCard getCard() {
	return card;
    }

    public void setCard(CreditCard card) {
	this.card = card;
    }

    @Override
    public String toString() {
	return "Customer [id=" + id + ", firstName=" + firstName
		+ ", lastName=" + lastName + ", address=]";
    }

}
