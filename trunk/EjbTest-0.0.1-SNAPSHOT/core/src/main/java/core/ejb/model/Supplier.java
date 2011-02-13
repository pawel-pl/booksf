package core.ejb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Object represents suppliers in application.
 */
@Entity
@Table(name = "SUPPLIER")
public class Supplier extends BaseModel {

	private static final long serialVersionUID = 6451167761761315254L;
	
	@Id
	@Column(name = "SUPPLIER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "DESCRIPTION", length = 255, nullable = false)
	private String description;
	
	@Embedded
	private Address address;

	@OneToMany(mappedBy="supplier", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Product> products = new HashSet<Product>();
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addProduct(Product prod){
		
		if(products == null){
			products = new HashSet<Product>();
		}
		prod.setSupplier(this);
		products.add(prod);
	}
	
	public void removeProduct(Product prod){
		
		if(products == null){
			return;
		}
		if(products.contains(prod)){
			products.remove(prod);
		}
	}
}
