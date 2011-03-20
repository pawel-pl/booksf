package core.ejb.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="ANIMAL")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="DISC_COL", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="Animal")
public class Animal extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4899531640173680596L;

	public Animal(){
		
	}
	
	public Animal(String name) {
		super();
		this.name = name;
	}

	@Id
	@TableGenerator(name="ANIMAL_GEN", pkColumnName="ID_NAME", valueColumnName="ID_VALUE", pkColumnValue="CUST_ID", table="GENERATOR")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ANIMAL_GEN")
/*	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ANIMAL_ID", nullable=false)*/
	private Long id;
	
	@Column(name="name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
