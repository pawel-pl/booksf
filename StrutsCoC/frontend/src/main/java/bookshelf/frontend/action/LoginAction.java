package bookshelf.frontend.action;

import static com.opensymphony.xwork2.Action.INPUT;

import java.util.Arrays;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.util.StringUtils;

import static bookshelf.core.constants.WebConst.*;
import bookshelf.core.facade.user.UserFacade;
import bookshelf.core.validation.ValidationHelper;
import bookshelf.model.object.User;

@Results({
	  @Result(name=RESULT.WELLCOME, location=ACTIONS.WELLCOME, type="redirect"),
	  @Result(name=INPUT, location=VIEWS.LOGIN)
	})
public class LoginAction extends BookshelfSupport implements SessionAware {

	private static final long serialVersionUID = -4297232001535479555L;
	
	private static final Logger LOG = Logger.getLogger(LoginAction.class);
	
	private UserFacade userFacade;
	
	private User user;
	
	private Map<String, Object> session;
	
	@SkipValidation
	@Override
	public String execute() {
		
		LOG.debug("LoginAction execute");
        return SUCCESS;      
    }
	

	@Action("/loginExecute")
	public String login() throws Exception{
		
		if(user == null){
			return INPUT;
		}
		
		LOG.debug("process login");
		User userFromDB = userFacade.findByLogin(user.getLogin(), user.getPassword());
		
		if (userFromDB == null) {
			addActionError(getText("user.not.found", "User not found"));
			return INPUT;
		}
		
		session.put(ATTRIBUTE.USER, userFromDB);
		
		return RESULT.WELLCOME;
	}


	@Override
	public void validate() {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Process login validation");
		}
		
		if(user == null){
			return;
		}
		
		if (!StringUtils.hasLength(user.getLogin())) {
			addFieldError("user.login", getText("field.required", "Field is required", Arrays.asList(new Object[]{"login"})));
		}
		
		if (!StringUtils.hasLength(user.getPassword())) {
			addFieldError("user.password", getText("field.required", "Field is required", Arrays.asList(new Object[]{"password"})));
		}
		
		if(!ValidationHelper.hasMinLength(user.getLogin(), ValidationHelper.LOGIN_MIN_LENGTH)){
			addFieldError("user.login", getText("field.min.lenght", "Field has invalid lenght", Arrays.asList(new Object[]{"login", ValidationHelper.LOGIN_MIN_LENGTH})));
		}
		
		if(!ValidationHelper.hasMinLength(user.getPassword(), ValidationHelper.PASSWORD_MIN_LENGTH)){
			addFieldError("user.password", getText("field.min.lenght", "Field has invalid lenght", Arrays.asList(new Object[]{"password", ValidationHelper.LOGIN_MIN_LENGTH})));
		}
		
		if(hasErrors()){
			addActionError(getText("form.contains.incorrect.data"));
		}
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		
		this.session = session;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

}
