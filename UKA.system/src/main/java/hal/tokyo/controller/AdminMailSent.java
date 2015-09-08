package hal.tokyo.controller;

import java.sql.SQLException;

import javax.naming.NamingException;

import hal.tokyo.dao.MailDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminMailSent {
	String message="Welcome to Spring MVC!";

	@RequestMapping("/AdminMailSent")
	public ModelAndView showMessage(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("user_id") String user_id
			) throws NamingException, SQLException {
		ModelAndView mv = new ModelAndView("/admin_mailsuctrans");
		MailDao md = new MailDao();
		System.out.println("spring側の"+title);
		System.out.println("spring側の"+content);
		System.out.println("spring側の"+user_id);
		mv.addObject("selectmail", md.AdminMailinsert(user_id,title,content));
		md.commit();
		md.close();
		return mv;
	}
}