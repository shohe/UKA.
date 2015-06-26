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
		System.out.println("index controller通過");


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
