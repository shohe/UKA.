package hal.tokyo.controller;

import hal.tokyo.dao.PostingInput;
import hal.tokyo.model.MultipleData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController extends HttpServlet{


	@Autowired
	ServletContext context;

	@RequestMapping(value="/viewtest", method=RequestMethod.POST)
	public ModelAndView getContent(@RequestParam("content") int contentId) {
		PostingInput dao = new PostingInput();
		String content = dao.selectCotent(contentId);
		ModelAndView mv = new ModelAndView("viewtest");
		mv.addObject("id",content);
		mv.addObject("content",content);
		return mv;
	}

	@RequestMapping(value="/postDetail", method=RequestMethod.GET)
	public ModelAndView getDetail() {
		ModelAndView mv = new ModelAndView("post");
		return mv;
	}

	@RequestMapping(value="/post", method=RequestMethod.GET)
	public ModelAndView getPost() {
		ModelAndView mv = new ModelAndView("posting_summary");
		return mv;
	}
	/**
	 * 詳細を投稿する際の場所
	 * @author kumagai
	 * @param muintitle
	 * @param texts
	 * @param titles
	 * @param files
	 * @return
	 * @throws IOException
	 */


	@RequestMapping(value="/post", method=RequestMethod.POST)
	public ModelAndView postPost(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("maintitle") String muintitle,
			@RequestParam("text[]") String[] texts,
			@RequestParam("title[]") String[] titles,
			@RequestParam("file[]") MultipartFile[] files) throws IOException {
		System.out.println("メインタイトル："+muintitle);
		ArrayList<MultipleData> malBean = new ArrayList<MultipleData>();
		for (int i=0; i<texts.length; i++) {
			String regex = "\r\n";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(texts[i]);
			String result = m.replaceAll("<br />");
			MultipleData fileBean = new MultipleData();
			fileBean.setDescription(result);
			System.out.println("本文："+result);
			fileBean.setTitle(titles[i]);
			System.out.println("タイトル："+titles[i]);
			if (files[i].getOriginalFilename().length() > 4) {
				File file = new File(createUploadPath(),getFileExtention(files[i].getOriginalFilename()));
				fileBean.setFile(file);
				System.out.println(file);
				fileBean.setMultipartFile(files[i]);
				//fileBean.setUrl("<c:url value='/resources/var/"+getFileExtention(files[i].getOriginalFilename())+"' />");
				fileBean.setUrl("/UKA.system/resources/var/"+getFileExtention(files[i].getOriginalFilename()));
				System.out.println("<c:url value='/resources/var/"+getFileExtention(files[i].getOriginalFilename())+"' />");
				fileBean.upload();
			}

			malBean.add(fileBean);
		}

		//DBに登録するものの編集
		String conCre = contentCreate(muintitle,malBean);

		//db登録詳細
		PostingInput Dao = new PostingInput();
		HttpSession session = request.getSession();
		String MailAddress = (String) session.getAttribute("MailAddress");
		Dao.insertDetail(MailAddress, conCre, muintitle, 0, 1,0);

		//ModelAndView mv = new ModelAndView("post_complete");
		ModelAndView mv = new ModelAndView("post_complete");
		//確認用
		//mv.addObject("conCre", "<img src=\"../../resorces/var/1435219826718the_screamy_wallpaperl.jpg\">"+conCre);mv.addObject("conCre", "<img src=\"../../resorces/var/1435219826718the_screamy_wallpaperl.jpg\">"+conCre);
		mv.addObject("conCre", conCre);

		return mv;
	}

	/**
	 * 概要を投稿する際の場所
	 * @author kumagai
	 * @param muintitle
	 * @param texts
	 * @param titles
	 * @param files
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/postSummary", method=RequestMethod.POST)
	public ModelAndView postSummary(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("maintitle") String muintitle,
			@RequestParam("text[]") String[] texts,
			@RequestParam("title[]") String[] titles,
			@RequestParam("file[]") MultipartFile[] files) throws IOException {
		System.out.println("メインタイトル："+muintitle);
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("Status"));
		if(session.getAttribute("Status").equals("false")){

			//ModelAndView mv = new ModelAndView("post_complete");
			ModelAndView mv = new ModelAndView("posting_summary");
			//確認用
			//mv.addObject("conCre", "<img src=\"../../resorces/var/1435219826718the_screamy_wallpaperl.jpg\">"+conCre);mv.addObject("conCre", "<img src=\"../../resorces/var/1435219826718the_screamy_wallpaperl.jpg\">"+conCre);
			mv.addObject("sessionErr", "noSession");

			return mv;

		}
		ArrayList<MultipleData> malBean = new ArrayList<MultipleData>();
		for (int i=0; i<texts.length; i++) {
			String regex = "\r\n";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(texts[i]);
			String result = m.replaceAll("<br />");
			MultipleData fileBean = new MultipleData();
			fileBean.setDescription(result);
			System.out.println("本文："+result);
			fileBean.setTitle(titles[i]);
			System.out.println("タイトル："+titles[i]+"\r\na");
			if (files[i].getOriginalFilename().length() > 4) {
				File file = new File(createUploadPath(),getFileExtention(files[i].getOriginalFilename()));
				fileBean.setFile(file);
				System.out.println(file);
				fileBean.setMultipartFile(files[i]);
				//fileBean.setUrl("<c:url value='/resources/var/"+getFileExtention(files[i].getOriginalFilename())+"' />");
				fileBean.setUrl("/UKA.system/resources/var/"+getFileExtention(files[i].getOriginalFilename()));
				//System.out.println("<c:url value='/resources/var/"+getFileExtention(files[i].getOriginalFilename())+"' />");
				fileBean.upload();
			}
			malBean.add(fileBean);
		}

		//DBに登録するものの編集
		String conCre = contentCreate(muintitle,malBean);

		//db登録詳細
		PostingInput Dao = new PostingInput();
		String MailAddress = (String) session.getAttribute("MailAddress");
		System.out.println(MailAddress);
		int id = Dao.insertSummary(MailAddress, conCre, muintitle, 1, 1,1);

		//ModelAndView mv = new ModelAndView("post_complete");
		ModelAndView mv = new ModelAndView("post_complete");
		//確認用
		//mv.addObject("conCre", "<img src=\"../../resorces/var/1435219826718the_screamy_wallpaperl.jpg\">"+conCre);mv.addObject("conCre", "<img src=\"../../resorces/var/1435219826718the_screamy_wallpaperl.jpg\">"+conCre);
		mv.addObject("id", id);

		return mv;
	}

	/**
	 * DB保存用の内容変換メソッド
	 * @author kumagai
	 * @param maintitle
	 * @param multiArray
	 * @return
	 */
	public String contentCreate(String maintitle ,ArrayList<MultipleData> multiArray) {
		String conCon = "";
		for (MultipleData multipleData : multiArray) {
			conCon += "<h2>"+multipleData.getTitle()+"</h2><br />"+"<p>"+multipleData.getDescription()+"</p><br />";
			if(multipleData.getUrl()!=null){
				conCon += "<br /><img class=\"detail_image\" src=\""+multipleData.getUrl()+"\"/><br />";
			}
		}
		System.out.println(conCon);
		return conCon;
	}

	@RequestMapping(value="/thankYou", method=RequestMethod.POST)
	public ModelAndView getPostComp() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	private String createUploadPath() {

		String path = context.getRealPath("\\");
		System.out.println("path::"+path);
		String[] paths = path.split("\\\\", 0);
		path = "";
		//int loop = 0;
		for (String p : paths) {
			//loop++;
			//System.out.println("loop:"+loop+"___p :"+p);
			path += p+"\\";
			if (p.equals("UKA")) {
				path += "UKA.system\\src\\main\\webapp\\resources\\var\\";
				break;
			}
		}


//		String path = context.getRealPath("/");
//		String[] paths = path.split("/", 0);
//		path = "";
//		for (String p : paths) {
//			path += p+"/";
//			if (p.equals("UKA.")) {
//				path += "UKA.system/src/main/webapp/resources/var/";
//				break;
//			}
//		}
		return path;
	}

	private String getFileExtention(String file) {
		String result = String.valueOf(Calendar.getInstance().getTimeInMillis());
		return result+file;
	}
}
