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
package core.ejb.logic.travelagent.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=false)
public class AppException extends Exception {

    private static final long serialVersionUID = -7940081356529111783L;
    
    public AppException(String s){
	super(s);
    }
}
