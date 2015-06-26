package hal.tokyo.controller;

import hal.tokyo.model.MultipleData;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
	 
	@RequestMapping(value="/post", method=RequestMethod.GET)
	public ModelAndView getPost() {
		ModelAndView mv = new ModelAndView("post");
		return mv;
	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public ModelAndView postPost(
			@RequestParam("text[]") String[] texts,
			@RequestParam("title[]") String[] titles,
			@RequestParam("file[]") MultipartFile[] files) throws IOException {
		
		for (int i=0; i<texts.length; i++) {
			MultipleData fileBean = new MultipleData();
			fileBean.setDescription(texts[i]);
			fileBean.setTitle(titles[i]);
			if (files[i].getOriginalFilename().length() > 4) {
				File file = new File(createUploadPath(),getFileExtention(files[i].getOriginalFilename()));
				fileBean.setFile(file);
				fileBean.setMultipartFile(files[i]);
				fileBean.setUrl("<c:url value='/resources/var/"+getFileExtention(files[i].getOriginalFilename())+"' />");
				fileBean.upload();
			}
		}
		
		ModelAndView mv = new ModelAndView("post_complete");
		return mv;
	}
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="/thankYou", method=RequestMethod.POST)
	public ModelAndView getPostComp() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	private String createUploadPath() {
		String path = context.getRealPath("/");
		String[] paths = path.split("/", 0);
		path = "";
		for (String p : paths) {
			path += p+"/";
			if (p.equals("UKA.")) {
				path += "UKA.system/src/main/webapp/resources/var/";
				break;
			}
		}
		return path;
	}
	
	private String getFileExtention(String file) {
		String result = String.valueOf(Calendar.getInstance().getTimeInMillis());
		return result+file;
	}
}
