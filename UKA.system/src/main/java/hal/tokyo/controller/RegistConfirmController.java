package hal.tokyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistConfirmController {

	@RequestMapping("/regist_confirm_con")
	public ModelAndView showMessage(@RequestParam("department_Id") String department_Id,
									@RequestParam("mailaddress") String mailaddress,
									@RequestParam("name") String name,
									@RequestParam("password") String password,
									@RequestParam("password_c") String password_c,
									@RequestParam("profileComment") String profileComment) {
		ModelAndView mv = new ModelAndView("regist_confirm");
		mv.addObject("department_Id", department_Id);
		mv.addObject("mailaddress", mailaddress);
		mv.addObject("name", name);
		mv.addObject("password", password);
		mv.addObject("passwor_c", password_c);
		mv.addObject("profileComment", profileComment);
		return mv;
	}

}
