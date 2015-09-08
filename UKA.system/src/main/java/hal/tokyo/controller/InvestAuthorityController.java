package hal.tokyo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import hal.tokyo.beans.UsersBean;
import hal.tokyo.dao.AdminAuthorityDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InvestAuthorityController {


		@RequestMapping("/investauth")
		public ModelAndView blockUser(@RequestParam(value = "status" , required = false) int status ,
				  @RequestParam(value = "name" , required = false) String name
					) {
			ModelAndView mv = new ModelAndView("admin_authorization");

			AdminAuthorityDao adminAuthorityDao = new AdminAuthorityDao();
			ArrayList<UsersBean> result = null;

			try {
				adminAuthorityDao.Authority(status, name);
				result = adminAuthorityDao.getAllUsers();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			mv.addObject("result", result);

			return mv;
		}
}