package hal.tokyo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.tokyo.dao.VotesDao;

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
/*
 @Controller
 public class CntUpVote {
 */
/**
 * 
 * @param postId
 */
/*
 * @RequestMapping(value = "/cntupvote", method = RequestMethod.GET) public
 * ModelAndView CntUpVoteUpdate(@RequestParam("post_id") int postId) {
 */
@WebServlet("/cntupvote")
public class CntUpVote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CntUpVote() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String jsppage = "/WEB-INF/views/error";
		String tmpPostId = request.getParameter("post_id");
		int postId = Integer.parseInt(tmpPostId);
		VotesDao votesDao = null;

		try {
			System.out.println(postId);
			System.out.println("daoに行く手前");
			votesDao = new VotesDao();
			try {
				votesDao.Voteupdate(postId);
				votesDao.commit();
				// 処理成功ページ
				/*jsppage = "/WEB-INF/views/detail?post_id=" + postId;
				System.out.println(jsppage);*/
				/*
				 * ModelAndView modelAndView = new ModelAndView(truepage);
				 * System.out.println(modelAndView); return modelAndView;
				 */
				
				IdeaDetailView ideaDetailView = new IdeaDetailView();
				ideaDetailView.OutPutIdeaDetail(postId);
				
			} catch (SQLException e) {
				votesDao.rollback();
				e.printStackTrace();
				System.out.println(e);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(jsppage);
		dispatcher.forward(request, response);
		/*
		 * ModelAndView modelAndView = new ModelAndView("error"); return
		 * modelAndView;
		 */
	}
}
