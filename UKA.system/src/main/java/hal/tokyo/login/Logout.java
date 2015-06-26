package hal.tokyo.login;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/Logout")
public class Logout extends HttpServlet {

	HttpSession session;
	public Logout() {
		session.removeAttribute("Name");
		session.removeAttribute("Status");

	}



}
