package hal.tokyo.controller;

import java.sql.SQLException;

import hal.tokyo.dao.AdminAuthorityDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class BlockUserController {


	@Controller
	public class HelloWorldController {
		String message="Welcome to Spring MVC!";

		@RequestMapping("/blockuser")
		public ModelAndView blockUser(@RequestParam(value = "status" , required = false) int status ,
				  @RequestParam(value = "name" , required = false) String name
					) {
			ModelAndView mv = new ModelAndView("admin_authorization");

			AdminAuthorityDao adminAuthorityDao = new AdminAuthorityDao();

			try {
				adminAuthorityDao.blockUser(status, name);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			mv.addObject("message", message);
//
			return mv;
		}
	}
}