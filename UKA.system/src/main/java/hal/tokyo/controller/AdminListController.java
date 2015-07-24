package hal.tokyo.controller;

import hal.tokyo.beans.PostingsBean;
import hal.tokyo.dao.AdminSearchDao;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminListController {

	@RequestMapping("/adminlist")
	public ModelAndView allGetPost(@RequestParam(value = "search" , required = false) String search) {
		ModelAndView mv = new ModelAndView("admin_projectinspection");

		AdminSearchDao adminSearchDao = new AdminSearchDao();
		ArrayList<PostingsBean> result = null;

		if(search == null || search.equals("")){
			try {
				result = adminSearchDao.getAllPostings();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			mv.addObject("result", result);
			return mv;
		}

		try {
			result = adminSearchDao.adminSearchChar(search);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		mv.addObject("result", result);
		return mv;
	}
}
