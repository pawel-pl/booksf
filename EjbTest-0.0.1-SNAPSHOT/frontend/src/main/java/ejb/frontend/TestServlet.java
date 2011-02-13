package ejb.frontend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;


public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 5800507975404296685L;

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		
		System.out.println("Dupa 123");
	}
}
