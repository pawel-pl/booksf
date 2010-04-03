package bookshelf.frontend.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import bookshelf.core.constants.WebConst;
import bookshelf.core.exception.ErrorMsgHolder;
import bookshelf.core.facade.customer.CustomerFacade;
import bookshelf.model.object.Customer;

@Controller
@RequestMapping("/editCustomer.do")
@SessionAttributes(WebConst.ATTRIBUTE.CUSTOMER)
public class EditCustomerController extends BaseController {

	private static final Logger LOG = Logger.getLogger(EditCustomerController.class);
	
	@Autowired
	@Qualifier(value="customerFacade")
	private CustomerFacade customerFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public Object prepareForm(@RequestParam("custId") Long custId, Model model) throws Exception {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Preparing form to show customers for edit");
		}
		
		Customer cust = customerFacade.getCustomerById(custId.intValue());
		
		if (cust == null) {
			ErrorMsgHolder msgHolder = new ErrorMsgHolder();
			msgHolder.addError("object.with.id.not.found", new Object[]{custId});
			Map<String, Object> attribs = new HashMap<String, Object>();
			attribs.put(WebConst.ATTRIBUTE.GLOBAL_ERROR, msgHolder);
			attribs.put(WebConst.ATTRIBUTE.CUSTOMERS, customerFacade.findAllCustomers());
			
			return new ModelAndView(WebConst.VIEWS.CUST_LIST_TO_EDIT, attribs);
		}
		
		model.addAttribute(WebConst.ATTRIBUTE.CUSTOMER, cust);
		
		return WebConst.VIEWS.CUST_EDIT;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object submitForm(Customer customer, BindingResult result, Model model) throws Exception {
		
		if(result.hasErrors()){
			return WebConst.VIEWS.CUST_EDIT;
		}
		
		validate(customer, result);
		
		if(result.hasErrors()){
			return WebConst.VIEWS.CUST_EDIT;
		}
		
		customerFacade.saveOrUpdateCustomer(customer);
		
		return new ModelAndView(WebConst.VIEWS.CUST_LIST_TO_EDIT,
				WebConst.ATTRIBUTE.CUSTOMERS, customerFacade.findAllCustomers());
	}
}
