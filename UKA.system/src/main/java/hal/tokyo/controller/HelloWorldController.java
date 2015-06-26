package hal.tokyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * +---------------------------------------+
 *   !このコントローラーはテスト用に作ったモノです!
 * +---------------------------------------+
 * @author shohe
 *
 */
@Controller
public class HelloWorldController {
	String message="Welcome to Spring MVC!";

	@RequestMapping("/hello")
	public ModelAndView showMessage(/*@RequestParam("test") String test*/) {
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
//		mv.addObject("test", test);
		return mv;
	}
}
