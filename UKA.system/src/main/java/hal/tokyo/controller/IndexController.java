package hal.tokyo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import hal.tokyo.beans.PostingsBean;
import hal.tokyo.dao.PostingsDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView gotoIndex() {
		ModelAndView mv = new ModelAndView("index");
		//変数宣言
		ArrayList<PostingsBean> result = null;

		PostingsDao postingsDao = new PostingsDao();
		try {
			result = postingsDao.getPostings();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		mv.addObject("result", result);
		return mv;
	}
}
