package core.ejb.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Object contains common operations for all model objects.
 */
public  abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = -8964545886347199089L;

	public boolean equals(Object obj){
		
		if(obj == null || !obj.getClass().equals(this.getClass())){
			return false;
		}
		
		if(obj == this){
			return true;
		}
		
		return ((BaseModel)obj).getId().equals(this.getId());
	}
	
	public int hashCode(){
		
		return new HashCodeBuilder().append(getId()).hashCode();
	}

	public String toString(){
		
		return String.valueOf(getId());
	}
	
	public abstract Long getId();	
}
