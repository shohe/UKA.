package hal.tokyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailComplete {
	String message="Welcome to Spring MVC!";
	
	@RequestMapping("/mailok")
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("/mailok");
		mv.addObject("message", message);
		return mv;
	}

}
