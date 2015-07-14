package hal.tokyo.controller;


import hal.tokyo.dao.MailDao;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Mails {
	@RequestMapping("MailCheck")
	public ModelAndView showMessage(
			@RequestParam("user_id") String user_id,
			@RequestParam("post_id") String post_id,
			@RequestParam("title") String title,
			@RequestParam("content") String content)  {

		MailCheckNull mcn = new MailCheckNull();

		//error messages
		String mcn_title = "";
		String mcn_content = "";

		//test start
		mcn_title = mcn.TitleNullCheck(title);
		mcn_content = mcn.TitleNullCheck(content);

		if(!mcn_title.equals("") || !mcn_content.equals("")){
			ModelAndView mv = new ModelAndView("mailstart");
			mv.addObject("title",title);
			mv.addObject("context",content);
			mv.addObject("err_title",mcn_title);
			mv.addObject("err_context",mcn_content);

			return mv;
		}else{

			/** 確認画面へ **/
			ModelAndView mv = new ModelAndView("mailAff");
			mv.addObject("user_id",user_id);
			mv.addObject("post_id",post_id);
			mv.addObject("title",title);
			mv.addObject("content",content);
			return mv;


		}

	}
	
}
