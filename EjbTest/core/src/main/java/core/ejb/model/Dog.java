package core.ejb.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="DOG")
@PrimaryKeyJoinColumn(name="DOG_ID")
@DiscriminatorValue(value="Dog")
public class Dog extends Animal {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2373647532473421053L;

	public Dog(){
		
	}
	
	public Dog(int noOfLegs) {
		super();
		this.noOfLegs = noOfLegs;
	}

/*	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOG_ID", nullable=false)
	private Long dogId;*/
	
	@Column(name="NO_OF_LEGS", nullable=false)
	private int noOfLegs;

/*	public Long getDogId() {
		return dogId;
	}

	public void setDogId(Long dogId) {
		this.dogId = dogId;
	}*/

	public int getNoOfLegs() {
		return noOfLegs;
	}

	public void setNoOfLegs(int noOfLegs) {
		this.noOfLegs = noOfLegs;
	}
	
}
