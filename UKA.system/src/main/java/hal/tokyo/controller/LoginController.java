package hal.tokyo.controller;

import hal.tokyo.beans.UsersBean;
import hal.tokyo.dao.UsersDao;

import java.sql.SQLException;
import java.util.List;

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
					List<UsersBean> bean = (List<UsersBean>) dao.findById(MailAddress, Password);
					record = (UsersBean) bean.get(0);
					
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				if(record.getMailaddress() != null){
					if(record.getMailaddress().equals(MailAddress)){
						//認証成功
						session.setAttribute("Name", record.getName());
						session.setAttribute("MailAddress", record.getMailaddress());
						session.setAttribute("Status", "true");
					}else{

						session.setAttribute("Status", "false");
					}
				}else{
					ModelAndView mv = new ModelAndView("index");
					mv.addObject("message", message);
					return mv;
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
