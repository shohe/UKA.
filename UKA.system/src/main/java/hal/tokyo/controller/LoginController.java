package hal.tokyo.controller;

import hal.tokyo.beans.UsersBean;
import hal.tokyo.dao.UsersDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kosaka
 *
 */
@Controller
public class LoginController extends HttpServlet {
	String message="Welcome to Spring MVC!";

	@RequestMapping("/login")
	public ModelAndView showMessage(HttpServletRequest request, HttpServletResponse response,@RequestParam("Email") String MailAddress, @RequestParam("Password") String Password, @RequestParam("login") String login) {

		String Login = "login";

		if(MailAddress.isEmpty()){
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("message", message);
			return mv;
		}

		UsersDao dao = new UsersDao();
		UsersBean record = new UsersBean();

		HttpSession session = request.getSession();
			if(request.getParameter("login").equals(Login)){
				try {
						record = dao.findById(MailAddress, Password);

						if(record.getMailAddress() != null){
							if(record.getMailAddress().equals(MailAddress)){
								//認証成功
								session.setAttribute("Name", record.getName());
								session.setAttribute("MailAddress", record.getMailAddress());
								session.setAttribute("Status", "true");
								System.out.println(record.getMailAddress());
								System.out.println(record.getName());
							}else{

								session.setAttribute("Status", "false");
							}
						}else{
							ModelAndView mv = new ModelAndView("index");
							mv.addObject("message", message);
							return mv;
						}
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}else{
				session.removeAttribute("Name");
				session.removeAttribute("MailAddress");
				session.removeAttribute("Status");
			}

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", message);
		return mv;
	}
}
