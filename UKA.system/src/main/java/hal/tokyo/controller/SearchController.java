package hal.tokyo.controller;

import hal.tokyo.beans.PostingsBean;
import hal.tokyo.dao.PostingsDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {


		@RequestMapping(value = "/search")
		public ModelAndView showSearch(@RequestParam(value = "search" , required = false) String search) {
			ModelAndView mv = new ModelAndView("search");
			PostingsDao postingsDao = new PostingsDao();
			ArrayList<PostingsBean> result = null;

			//searchに何も入れないで押下された場合
			if(search == null || search.equals("")){
				try {
					result = postingsDao.getPostings();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				Collections.shuffle(result);
				mv.addObject("result", result);
				return mv;
			}


			try {
				result = postingsDao.searchChar(search);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				System.out.println("SQL Error");
				e.printStackTrace();
			}
			//list型を送る
			Collections.shuffle(result);
			mv.addObject("result", result);

			return mv;
		}

}
