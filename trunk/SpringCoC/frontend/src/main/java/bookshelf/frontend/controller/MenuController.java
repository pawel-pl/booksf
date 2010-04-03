package bookshelf.frontend.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bookshelf.core.constants.WebConst;
import bookshelf.core.exception.ErrorMsgHolder;
import bookshelf.core.facade.customer.CustomerFacade;
import bookshelf.model.object.Customer;

@Controller
public class MenuController extends BaseController{

	private static final Logger LOG = Logger.getLogger(MenuController.class);
	
	@Autowired
	@Qualifier(value="customerFacade")
	private CustomerFacade customerFacade;
	
	@RequestMapping("/wellcome.do")
	public void wellcome() {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Wellcome!");
		}
	}
	
	@RequestMapping("/rentBook.do")
	public ModelAndView rentBook() throws Exception {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Rent Book!");
		}
		
		ModelAndView model = new ModelAndView(WebConst.VIEWS.CUSTOMERS,
				WebConst.ATTRIBUTE.CUSTOMERS, customerFacade.findAllCustomers());
		
		return model;
	}
	
	@RequestMapping("/custListToEdit.do")
	public ModelAndView custListToEdit() throws Exception {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("edit customer list!");
		}
		
		ModelAndView model = new ModelAndView(WebConst.VIEWS.CUST_LIST_TO_EDIT,
				WebConst.ATTRIBUTE.CUSTOMERS, customerFacade.findAllCustomers());
		
		return model;
	}
	
	@RequestMapping("/customer.do")
	public ModelAndView customer(@RequestParam("custId") int custId) throws Exception {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Customer!");
		}
		
		Customer cust = customerFacade.getCustomerById(custId);
		
		if (cust == null) {
			ErrorMsgHolder msgHolder = new ErrorMsgHolder();
			msgHolder.addError("object.with.id.not.found", new Object[]{custId});
			Map<String, Object> attribs = new HashMap<String, Object>();
			attribs.put(WebConst.ATTRIBUTE.GLOBAL_ERROR, msgHolder);
			attribs.put(WebConst.ATTRIBUTE.CUSTOMERS, customerFacade.findAllCustomers());
			
			return new ModelAndView(WebConst.VIEWS.CUSTOMERS, attribs);
		}
		
		return new ModelAndView(WebConst.VIEWS.CUSTOMER,
				WebConst.ATTRIBUTE.CUSTOMER, cust);
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}

}
