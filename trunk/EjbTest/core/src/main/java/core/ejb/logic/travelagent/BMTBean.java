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
package core.ejb.logic.travelagent;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class BMTBean implements BMTBeanRemote{

    @Resource
    private UserTransaction tx;
    
    @Resource
    private EJBContext ctx;
    
    public void methodWithUserTx(){
	
	try {
	    tx.begin();
	    System.out.println("In user tx");
	    ctx.setRollbackOnly();
	    tx.commit();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
