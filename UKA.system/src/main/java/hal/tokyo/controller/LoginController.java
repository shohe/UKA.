package hal.tokyo.controller;

import hal.tokyo.login.LoginModule;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * +---------------------------------------+
 *   !このコントローラーはテスト用に作ったモノです!
 * +---------------------------------------+
 * @author shohe
 *
 */
@Controller
public class LoginController extends HttpServlet {
	String message="Welcome to Spring MVC!";

	@RequestMapping("/login")
	public ModelAndView showMessage(HttpServletRequest request, HttpServletResponse response,@RequestParam("Email") String MailAddress, @RequestParam("Password") String Password, @RequestParam("login") String login) {

		String Login = "login";


		LoginModule loginm = new LoginModule();


		HttpSession session = request.getSession(false);
			if(request.getParameter("login").equals(Login)){
				String name = loginm.Login(MailAddress, Password);
				if(name.equals(MailAddress)){
					//認証成功
					session.setAttribute("Name", name);
					session.setAttribute("Status", "true");
				}else{
					session.setAttribute("Status", "false");
				}
			}else{
				session.removeAttribute("Name");
				session.removeAttribute("Status");
			}

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", message);
		mv.addObject("Email",MailAddress );
		mv.addObject("Password",Password );
		mv.addObject("login",login );
		return mv;
	}
}
