package bookshelf.core.constants;

public class WebConst {

	public static final String ENCODING = "UTF-8";
	
	public static class ATTRIBUTE{
		public static final String USER = "user";
	}
	
	public static class VIEWS {
		public static final String LOGIN = "login.jsp";
		public static final String CUSTOMERS = "customers.jsp";
		public static final String CUSTOMER = "customer.jsp";
		public static final String RENT_BOOK = "rentBook.jsp";
		public static final String REMOVE_BOOK = "removeBook.jsp";
		public static final String CUSTOMER_EDIT_LIST = "customer-edit-list.jsp";
		public static final String CUSTOMER_EDIT_FORM = "customer-edit.jsp";
		public static final String CUSTOMER_ADD_FORM = "customer-add.jsp";
		public static final String BOOK_EDIT_LIST = "book-edit-list.jsp";
		public static final String BOOK_EDIT_FORM = "book-edit.jsp";
	}
	
	public static class ACTIONS {
		public static final String WELLCOME = "/wellcome.action";
	}
	
	public static class RESULT{
		public static final String WELLCOME = "wellcome";
		public static final String CUSTOMERS = "customers";
		public static final String CUSTOMER = "customer";
		public static final String CUSTOMER_EDIT_LIST = "customerEditList";
		public static final String BOOK_EDIT_LIST = "bookEditList";
		public static final String RENT_BOOK = "rentBook";
	}
}
