package hal.tokyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {

	@RequestMapping("/mypage")
	public ModelAndView showMessage(/*@RequestParam("test") String test*/) {
		ModelAndView mv = new ModelAndView("mypage");
//		mv.addObject("test", test);
		return mv;
	}
}
