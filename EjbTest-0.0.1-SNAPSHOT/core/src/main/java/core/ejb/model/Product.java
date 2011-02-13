package core.ejb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

/**
 * Object represents products in application.
 */
@Entity
@Table(name = "PRODUCT")
public class Product extends BaseModel {

	private static final long serialVersionUID = 5371941856595805755L;

	@Id
	@Column(name = "PRODUCT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NAME", length = 100, nullable = false)
	private String name;
	
	@Column(name = "PRICE", length = 3, nullable = false)
	private Float price;
	
	@Column(name = "QUANTITY", length = 3, nullable = false)
	private Integer quantity;
	
	@Column(name = "DESCRIPTION", length = 255, nullable = false)
	private String description;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name = "SUPPLIER_ID", nullable=false)
	@ForeignKey(name="prod_to_sup_fk", inverseName="sup_to_prod_fk")
	private Supplier supplier;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
