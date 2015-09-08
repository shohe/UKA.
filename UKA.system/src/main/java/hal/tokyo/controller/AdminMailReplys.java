package hal.tokyo.controller;

import java.sql.SQLException;

import javax.naming.NamingException;

import hal.tokyo.dao.MailDao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class AdminMailReplys {
	String message="Welcome to Spring MVC!";

	@RequestMapping("/AdminMailReplyServlet")
	public ModelAndView showMessage() throws NamingException, SQLException {
		ModelAndView mv = new ModelAndView("/AdminMailReplyServlet");
		MailDao md = new MailDao();
		mv.addObject("AdminMailReplyServlet", md.AllAdminMailselect());
		return mv;
	}
	


}
