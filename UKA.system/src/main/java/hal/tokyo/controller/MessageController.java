package hal.tokyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {
	@RequestMapping("/message")
	public ModelAndView gotoMail() {
		ModelAndView mv = new ModelAndView("message");
		return mv;
	}
}
