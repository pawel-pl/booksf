package bookshelf.frontend.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import bookshelf.core.constants.WebConst.RESULT;
import bookshelf.core.constants.WebConst.VIEWS;

import com.opensymphony.xwork2.ActionSupport;

@Results({
	  @Result(name=RESULT.ERROR, location=VIEWS.ERROR)
	})
public abstract class BookshelfSupport extends ActionSupport{

	private static final long serialVersionUID = -2328651207378486980L;
	
}
