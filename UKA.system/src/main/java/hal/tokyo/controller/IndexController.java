package hal.tokyo.controller;

import hal.tokyo.beans.PostingsBean;
import hal.tokyo.dao.PostingsDao;

import java.sql.SQLException;
import java.util.ArrayList;

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
		ArrayList<PostingsBean> random = null;

		PostingsDao postingsDao = new PostingsDao();
		try {
			random = postingsDao.getOneRandom();
			result = postingsDao.getPostings();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//random.get(0).
		mv.addObject("random", random);
		mv.addObject("result", result);
		return mv;
	}
}
