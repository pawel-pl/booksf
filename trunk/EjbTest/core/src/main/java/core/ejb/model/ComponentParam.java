package core.ejb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMPONENT_PARAM")
public class ComponentParam extends BaseModel{

	private static final long serialVersionUID = -7777685285711481697L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PARAM_ID", nullable=false)
	private Long id;

	@Column(name="PARAM_NAME", nullable=false)
	private String name;
	
	@OneToOne(mappedBy="param")
	private Component comp;
	
	public ComponentParam(){
		
	}

	public ComponentParam(String name){
		
		this.name = name;
	}
	
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

	public Component getComp() {
		return comp;
	}

	public void setComp(Component comp) {
		this.comp = comp;
	}
	
}
