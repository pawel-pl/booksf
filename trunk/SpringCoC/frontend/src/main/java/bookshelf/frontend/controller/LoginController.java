package bookshelf.frontend.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import bookshelf.core.constants.WebConst;
import bookshelf.core.facade.user.UserFacade;
import bookshelf.frontend.filter.LoginFilter;
import bookshelf.model.object.User;

@Controller
@RequestMapping("/login.do")
@SessionAttributes(WebConst.ATTRIBUTE.USER)
public class LoginController extends BaseController {

	private static final Logger LOG = Logger.getLogger(LoginFilter.class);
	
	@Autowired
	@Qualifier(value="userFacade")
	private UserFacade userFacade;
	
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields(new String[] {"id"});
    }
    
	@RequestMapping(method = RequestMethod.GET)
	public Object prepareForm(Model model) throws Exception {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Preparing form to login");
		}
		model.addAttribute(WebConst.ATTRIBUTE.USER, new User());
		
		return WebConst.VIEWS.LOGIN;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object submitForm(User user, BindingResult result, Model model, HttpServletRequest request) throws Exception {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Processing login...");
		}
		
		validate(user, result);
		
		if(result.hasErrors()){
			return saveErrorsAndReturnToForm(model, result);
		}
		
		User userFromDB = userFacade.findByLogin(user.getLogin(), user.getPassword());
		
		if (userFromDB == null) {
			result.reject("user.not.found", "User not found");
			return saveErrorsAndReturnToForm(model, result);
		}
		userFromDB.setLogged(true);
		model.addAttribute(WebConst.ATTRIBUTE.USER, userFromDB);
		
		return new RedirectView(WebConst.ACTIONS.WELLCOME);
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}
	
	private Object saveErrorsAndReturnToForm(Model model, Errors errors){
		
		model.addAttribute(WebConst.ATTRIBUTE.ERRORS, errors);
		return WebConst.VIEWS.LOGIN;
	}

}
