package bookshelf.frontend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import bookshelf.core.constants.WebConst;
import bookshelf.core.facade.customer.CustomerFacade;
import bookshelf.model.object.Customer;

@Controller
@RequestMapping("/addCustomer.do")
@SessionAttributes(WebConst.ATTRIBUTE.CUSTOMER)
public class AddCustomerController extends BaseController{

	private static final Logger LOG = Logger.getLogger(AddCustomerController.class);
	
	@Autowired
	@Qualifier(value="customerFacade")
	private CustomerFacade customerFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public Object prepareForm(Model model) throws Exception {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Preparing form to add customer");
		}
		
		model.addAttribute(WebConst.ATTRIBUTE.CUSTOMER, new Customer());
		
		return WebConst.VIEWS.CUST_ADD;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object submitForm(Customer customer, BindingResult result, Model model) throws Exception {
		
		if(result.hasErrors()){
			return WebConst.VIEWS.CUST_ADD;
		}
		
		validate(customer, result);
		
		if(result.hasErrors()){
			return WebConst.VIEWS.CUST_ADD;
		}
		
		customerFacade.saveOrUpdateCustomer(customer);
		
/*		return new ModelAndView(WebConst.VIEWS.CUST_LIST_TO_EDIT,
				WebConst.ATTRIBUTE.CUSTOMERS, customerFacade.findAllCustomers());*/
		
		return new RedirectView(WebConst.ACTIONS.WELLCOME);
	}
}
