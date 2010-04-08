package bookshelf.frontend.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import bookshelf.core.constants.WebConst.ACTIONS;
import bookshelf.core.constants.WebConst.ATTRIBUTE;
import bookshelf.core.constants.WebConst.RESULT;

@Results({
	  @Result(name=RESULT.WELLCOME, location=ACTIONS.WELLCOME, type="redirect")
	})
public class LogoutAction extends BookshelfSupport implements SessionAware{

	private static final long serialVersionUID = -4390120126934992200L;

	private static final Logger LOG = Logger.getLogger(LogoutAction.class);
	
	private Map<String, Object> session;
	
	@Override
	public String execute() throws Exception {

		if(LOG.isDebugEnabled()){
			LOG.debug("LogoutAction execute");
		}
		
		session.remove(ATTRIBUTE.USER);
		
		return RESULT.WELLCOME;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		
		this.session = session;
	}
	
}
