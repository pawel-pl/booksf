package bookshelf.frontend.action;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class WellcomeAction extends BookshelfSupport{

	private static final long serialVersionUID = -5821625690142354251L;

	private static final Logger LOG = Logger.getLogger(WellcomeAction.class);
	
	@SkipValidation
	@Override
	public String execute() {
		
		LOG.debug("WellcomeAction execute");
        return SUCCESS;      
    }
}
