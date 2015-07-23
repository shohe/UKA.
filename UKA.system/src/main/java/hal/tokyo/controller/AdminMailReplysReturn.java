package hal.tokyo.controller;

import java.sql.SQLException;

import javax.naming.NamingException;

import hal.tokyo.dao.MailDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminMailReplysReturn {
	String message="Welcome to Spring MVC!";

	@RequestMapping("/AdminMailReplysReturn")
	public ModelAndView showMessage(@RequestParam("enquiry_id") String enquiry_id) throws NamingException, SQLException {
		ModelAndView mv = new ModelAndView("/admin_mailreply");
		MailDao md = new MailDao();
		mv.addObject("selectmail", md.AdminMailselect(enquiry_id));
		return mv;
	}
}