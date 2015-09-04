package hal.tokyo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import hal.tokyo.beans.UsersBean;
import hal.tokyo.dao.AdminAuthorityDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminAuthorityController {

	@RequestMapping("/adminauthority")
	public ModelAndView allGetUser() {
		ModelAndView mv = new ModelAndView("admin_authorization");

		AdminAuthorityDao adminAuthorityDao = new AdminAuthorityDao();
		ArrayList<UsersBean> result = null;

		try {
			result = adminAuthorityDao.getAllUsers();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		mv.addObject("result", result);

		return mv;
	}
}
