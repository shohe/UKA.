package hal.tokyo.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kosaka
 *
 */
@Controller
public class LogoutController extends HttpServlet {
	String message="logout";

	@RequestMapping("/logout")
	public ModelAndView showMessage(HttpServletRequest request, HttpServletResponse response) {

		String Logout = "ログアウト";
		System.out.print("logoutcontroller");



		HttpSession session = request.getSession();
				session.removeAttribute("Name");
				session.removeAttribute("MailAddress");
				session.removeAttribute("Status");
				session.invalidate();

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", message);
		return mv;
	}
}
