package core.ejb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CABIN")
public class Cabin extends BaseModel {

	private static final long serialVersionUID = 4308008611380238097L;

	public Cabin(){
	
	}
	
	public Cabin(Long id, String name, Integer deckLevel, Integer shipId,
			Integer bedCount) {

		this.id=id;
		this.name = name;
		this.deckLevel = deckLevel;
		this.shipId = shipId;
		this.bedCount = bedCount;
	}

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="DECK_LEVEL", nullable=false)
	private Integer deckLevel;
	
	@Column(name="SHIP_ID", nullable=false)
	private Integer shipId;
	
	@Column(name="BED_COUNT", nullable=false)
	private Integer bedCount;

	@Override
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

	public Integer getDeckLevel() {
		return deckLevel;
	}
	public void setDeckLevel(Integer deckLevel) {
		this.deckLevel = deckLevel;
	}

	public Integer getShipId() {
		return shipId;
	}
	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public Integer getBedCount() {
		return bedCount;
	}
	public void setBedCount(Integer bedCount) {
		this.bedCount = bedCount;
	}

	@Override
	public String toString() {
		return "Cabin [bedCount=" + bedCount + ", deckLevel=" + deckLevel
				+ ", id=" + id + ", name=" + name + ", shipId=" + shipId + "]";
	}
}
