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

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateful
public class StatefulBean implements StatefulBeanRemote {

    @EJB
    private TestBeanRemote testBean;

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void noTransactionMethod() {

	System.out.println("NOT_SUPPORTED");
	testBean.requiresNewTransaction();
    }
}
