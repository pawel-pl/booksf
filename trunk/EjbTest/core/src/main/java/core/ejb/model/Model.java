package core.ejb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Model {
    
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model() {
	
    }
    
    public Model(int id) {
	this.id = id;
    }
    
    
}
