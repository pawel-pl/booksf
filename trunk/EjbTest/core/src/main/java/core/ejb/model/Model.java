package core.ejb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SecondaryTable;
import javax.persistence.Version;

@Entity
@SecondaryTable(name="Version_Table")
@IdClass(ModelId.class)
public class Model implements Serializable{
    
    private int id;

    private int version;

    public Model() {
	
    }
    
    public Model(int id) {
	this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    @Column(name="version_number",  table="Version_Table")
    private int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    
}
