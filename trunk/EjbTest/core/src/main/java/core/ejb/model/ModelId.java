/*
 * Copyright (C) Nokia Siemens Networks
 * The reproduction, transmission or use of this document or its contents 
 * is not permitted without express written authorization.
 * Offenders will be liable for damages.
 * All rights, including rights created by patent grant or 
 * registration of a utility model or design, are reserved.
 * Modifications made to this document are restricted to authorized personnel only. 
 * Technical specifications and features are binding only when specifically 
 * and expressly agreed upon in a written contract.
 *
 * LISBON
 */
package core.ejb.model;

import java.io.Serializable;


public class ModelId implements Serializable {

    private static final long serialVersionUID = -3198072134098985676L;
    
    private int id;
    
    public ModelId(){
	
    }
    
    public ModelId(int id){
	
	this.id = id;
    }
    
    @Override
    public boolean equals(Object obj) {
	
	return obj instanceof Model && ((Model)obj).getId() == id ? true : false;
    }

    @Override
    public int hashCode() {
	
	return id;
    }

    private int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
