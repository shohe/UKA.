package hal.tokyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransitionSummary {
	
	@RequestMapping("/TransitionSummary")
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("posting_summary");
		return mv;
	}
}

