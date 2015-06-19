package hal.tokyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistController {
	@RequestMapping("/regist")
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("regist");
		return mv;
	}
}
