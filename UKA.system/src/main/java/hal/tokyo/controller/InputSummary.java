package hal.tokyo.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hal.tokyo.dao.PostingInput;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InputSummary {
	
	@RequestMapping("/InputSummary")
	public ModelAndView showMessage(@RequestParam("title") String title,@RequestParam("text") String text) {
		
		String img = "<img src = \"aaaaa.jpg\" >";
		
		String regex = "\r\n";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(text);
		String result = m.replaceAll("<br />");
		
		String htmlText = result + img;
		System.out.println(htmlText);
		
		//暫定
		final String USERID = "aaa@sample.com";

		PostingInput dao = new PostingInput();
		dao.insertSummary(USERID, htmlText, title, 0, 0, 0);
		 
		
		dao.clos();
		
		//OR failure
		ModelAndView mv = new ModelAndView("post_complete");
		
		return mv;
	}
}
