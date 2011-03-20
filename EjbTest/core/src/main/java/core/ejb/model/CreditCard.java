package core.ejb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard implements Serializable{

    private static final long serialVersionUID = -4352769519442301415L;
    
    @Id
    @Column(name="CC_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private long value;
    
    public CreditCard(){
	
    }

    public CreditCard(long value) {

	this.value = value;
    }

    @Override
    public String toString() {
	return "CreditCard [id=" + id + ", value=" + value + "]";
    }
    
}
