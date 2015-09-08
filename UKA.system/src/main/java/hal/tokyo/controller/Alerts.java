package hal.tokyo.controller;

import java.sql.SQLException;

import javax.naming.NamingException;

import hal.tokyo.dao.AlertDao;
import hal.tokyo.dao.MailDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Alerts {
	String message="Welcome to Spring MVC!";
	
	@RequestMapping("/alert")
	public ModelAndView showMessage() throws NamingException, SQLException {
		ModelAndView mv = new ModelAndView("/alert");
		AlertDao ad = new AlertDao();
		mv.addObject("alert", ad.AllMailselect());
		return mv;
	}

}
