package core.ejb.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = -2377991867704642954L;
    private String city;
    private String street;
    private Integer houseNo;

    public Address() {

    }

    public Address(String city, String street, Integer houseNo) {

	this.city = city;
	this.street = street;
	this.houseNo = houseNo;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getStreet() {
	return street;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public Integer getHouseNo() {
	return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
	this.houseNo = houseNo;
    }

    @Override
    public String toString() {
	return "Address [city=" + city + ", street=" + street + ", houseNo="
		+ houseNo + "]";
    }

}
