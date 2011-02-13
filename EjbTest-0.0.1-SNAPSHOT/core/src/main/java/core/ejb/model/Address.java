package core.ejb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Object represents address of {#link Supplier}.
 */
@Embeddable
public class Address implements Serializable {

	private static final long serialVersionUID = -6643166840154514741L;

	@Column(name = "CITY", length = 100, nullable = false)
	private String city;
	
	@Column(name = "STREET", length = 100, nullable = false)
	private String street;
	
	@Column(name = "POST_CODE", length = 20, nullable = false)
	private String postCode;
	
	@Column(name = "HOUSE_NO", length = 3, nullable = false)
	private Integer houseNo;
	
	@Column(name = "APP_NO", length = 3, nullable = false)
	private Integer appNo;

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

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Integer getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}

	public Integer getAppNo() {
		return appNo;
	}

	public void setAppNo(Integer appNo) {
		this.appNo = appNo;
	}
	
}
