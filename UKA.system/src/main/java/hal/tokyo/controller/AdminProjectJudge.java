package hal.tokyo.controller;

import java.sql.SQLException;

import javax.naming.NamingException;

import hal.tokyo.dao.MailDao;
import hal.tokyo.dao.PostingsDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminProjectJudge {
	String message="Welcome to Spring MVC!";

	@RequestMapping("/project_ok")
	public ModelAndView showMessage(
			@RequestParam("title") String title) throws NamingException, SQLException {
		ModelAndView mv = new ModelAndView("/admin_mailsuctrans");
		PostingsDao pd = new PostingsDao();
		System.out.println("spring側の"+title);
		mv.addObject("selectmail", pd.ProjectOk(title));
		pd.commit();
		pd.close();
		return mv;
	}
	
	@RequestMapping("/project_no")
	public ModelAndView showMessage2(
			@RequestParam("title") String title) throws NamingException, SQLException {
		ModelAndView mv = new ModelAndView("/admin_judge");
		PostingsDao pd = new PostingsDao();
		System.out.println("spring側の"+title);
		mv.addObject("selectmail", pd.ProjectOk(title));
		pd.commit();
		pd.close();
		return mv;
	}
}