package hal.tokyo.controller;

import hal.tokyo.beans.IdeaDetailViewBean;
import hal.tokyo.dao.IdeaDetailViewDao;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author enfumidayo
 *
 */
@Controller
public class IdeaDetailView {
	/**
	 *
	 * @param postId
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView OutPutIdeaDetail(@RequestParam("post_id") int postId) {
		IdeaDetailViewDao ideaDetailViewDao = null;
		IdeaDetailViewBean ideaDetailViewBean = new IdeaDetailViewBean();
		try {
			ideaDetailViewDao = new IdeaDetailViewDao();
			try {
				ideaDetailViewBean = ideaDetailViewDao.read(postId);
				ideaDetailViewDao.rollback();
				ModelAndView modelAndView = new ModelAndView("detail");
				modelAndView.addObject("title", ideaDetailViewBean.getTitle());
				modelAndView.addObject("date", ideaDetailViewBean.getDate());
				modelAndView.addObject("posting_content",
						ideaDetailViewBean.getPosting_content());
				modelAndView.addObject("image", ideaDetailViewBean.getImage());
				modelAndView.addObject("name", ideaDetailViewBean.getName());
				modelAndView.addObject("department_name",
						ideaDetailViewBean.getDepartment_name());
				modelAndView.addObject("profilecomment",
						ideaDetailViewBean.getProfilecomment());
				modelAndView.addObject("achievement_percentage",
						ideaDetailViewBean.getAchievement_percentage());
				modelAndView.addObject("timelimit",
						ideaDetailViewBean.getTimelimit());
				return modelAndView;
			} catch (SQLException e) {
				ideaDetailViewDao.rollback();
				e.printStackTrace();
				System.out.println(e);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		ModelAndView modelAndView = new ModelAndView("error");
		return modelAndView;
	}
}
