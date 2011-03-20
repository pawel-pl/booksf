package core.ejb.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMPONENT")
public class Component extends BaseModel{

	private static final long serialVersionUID = -7664940671290255940L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMPONENT_ID", nullable=false)
	private Long id;

	@Column(name="COMPONENT_NAME", nullable=false)
	private String name;
	
	//@OneToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
	@OneToOne(cascade={CascadeType.ALL})
/*	@JoinTable(name="Comp_Param",
			joinColumns={@JoinColumn(name="COMP_ID", unique=true)},
			inverseJoinColumns={@JoinColumn(name="PARAM_ID", unique=true)})*/
	@JoinColumn(name="PARAM_ID", unique=true)
	//@PrimaryKeyJoinColumn//(name="COMPONENT_ID", referencedColumnName="PARAM_ID")
	private ComponentParam param;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PARAM_MAP_ID")
	@MapKey(name="name")
	private Map<String, ComponentParam> paramsMap = new HashMap<String, ComponentParam>();
	
	public Component(){
		
	}

	public Component(String name){
		
		this.name = name;
		paramsMap.put("paramMap1", new ComponentParam("paramMap1"));
		paramsMap.put("paramMap2", new ComponentParam("paramMap2"));
		paramsMap.put("paramMap3", new ComponentParam("paramMap3"));
	}
	
	@Override
	public Long getId() {
		
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ComponentParam getParam() {
		return param;
	}

	public void setParam(ComponentParam param) {
		this.param = param;
		if(param != null){
			this.param.setComp(this);
	
		}
	}

	@Override
	public String toString() {
		return "Component [id=" + id + ", name=" + name + ", param=" + param
				+ ", paramsMap=" + paramsMap + "]";
	}
	
}
