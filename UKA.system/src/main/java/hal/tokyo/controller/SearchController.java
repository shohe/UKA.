package hal.tokyo.controller;

import hal.tokyo.beans.PostingsBean;
import hal.tokyo.dao.PostingsDao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {


		@RequestMapping("/search")
		public ModelAndView showSearch(@RequestParam(value = "search" , required = false) String search) {
			ModelAndView mv = new ModelAndView("search");

			if(search == null || search.equals("")){
				return mv;
			}

			ArrayList<PostingsBean> result = null;
			//test
			System.out.println("searchの内容:" + search);
			PostingsDao postingsDao = new PostingsDao();

			try {
				result = postingsDao.searchChar(search);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				System.out.println("SQLがエラーでとるで");
				e.printStackTrace();
			}

			for ( PostingsBean postingsBean  :  result ) {
				System.out.println("名前:"+ postingsBean.getName());
				System.out.println("タイトル:"+ postingsBean.getTitle());
				System.out.println("部署名:"+ postingsBean.getDepartment_name());
				System.out.println("パーセント:"+ postingsBean.getAchievement_percentage());
				System.out.println("イメージ:"+ postingsBean.getImage());
				System.out.println("プロフィールコメント:"+ postingsBean.getProfilecomment());
				System.out.println("投票数:"+ postingsBean.getAchievement_vote());
				System.out.println("期限:"+postingsBean.getTimelimit());
			}

			mv.addObject("result", result);

			return mv;
		}

}
