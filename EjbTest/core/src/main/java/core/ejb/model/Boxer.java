package core.ejb.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="BOXER")
@PrimaryKeyJoinColumn(name="BOXER_ID")
@DiscriminatorValue(value="Boxer")
public class Boxer extends Dog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5858681151875611248L;

	public Boxer(){
		
	}
	
	public Boxer(String color) {
		super();
		this.color = color;
	}

/*	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BOXER_ID", nullable=false)
	private Long boxerId;*/
	
	@Column(name="COLOR")
	private String color;

/*	public Long getBoxerId() {
		return boxerId;
	}

	public void setBoxerId(Long boxerId) {
		this.boxerId = boxerId;
	}*/

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
