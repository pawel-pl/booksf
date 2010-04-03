package bookshelf.frontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import bookshelf.core.constants.WebConst;

@Controller
@RequestMapping("/logout.do")
public class LogoutController {

	@RequestMapping(method = RequestMethod.GET)
	public Object logout(HttpSession session) {
		
		session.removeAttribute(WebConst.ATTRIBUTE.USER);
		
		return new RedirectView(WebConst.ACTIONS.WELLCOME);
	}
}
