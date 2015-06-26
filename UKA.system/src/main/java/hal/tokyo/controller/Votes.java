package hal.tokyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Votes {
	String message="Welcome to Spring MVC!";
	
	@RequestMapping("/testvote")
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("/testvote");
		mv.addObject("message", message);
		return mv;
	}

}
