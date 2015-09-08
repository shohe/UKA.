package hal.tokyo.controller;

import hal.tokyo.dao.MailDao;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EnquiryReceiveController {

	@RequestMapping("/enquiry_receive")
	public ModelAndView showMessage() throws NamingException, SQLException {
		ModelAndView mv = new ModelAndView("jushin");

		MailDao md = new MailDao();

		mv.addObject("enquiry", md.AllMailselect());

		return mv;
	}

}
