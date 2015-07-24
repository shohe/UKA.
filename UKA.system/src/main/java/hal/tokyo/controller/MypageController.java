package hal.tokyo.controller;

import hal.tokyo.beans.UsersBean;
import hal.tokyo.dao.UsersDao;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {

	@RequestMapping("/mypage")
	public ModelAndView showMessage() throws SQLException {
		ModelAndView mv = new ModelAndView("mypage");

		UsersDao ud = new UsersDao();

		UsersBean ub = new UsersBean();

		ub = ud.findByMailaddress("nitta@sample.com");

		mv.addObject("user", ub.getName());
		mv.addObject("image", ub.getImage());
		mv.addObject("mail", ub.getMailAddress());
		mv.addObject("profile", ub.getProfileComment());

		ud.close();
		ud = null;
		ub = null;

		return mv;
	}
}
